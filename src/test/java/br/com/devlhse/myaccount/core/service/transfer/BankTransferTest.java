package br.com.devlhse.myaccount.core.service.transfer;

import br.com.devlhse.myaccount.core.domain.transfer.Account;
import br.com.devlhse.myaccount.core.domain.transfer.exception.BankTransferException;
import br.com.devlhse.myaccount.core.domain.transfer.exception.SameAccountTransferException;
import br.com.devlhse.myaccount.core.service.transfer.out.FindAccountPort;
import br.com.devlhse.myaccount.core.service.transfer.out.SaveAccountPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankTransferTest {

    public static final long ORIGIN_ACCOUNT_ID = 1L;
    public static final long DESTINY_ACCOUNT_ID = 2L;

    @InjectMocks
    BankTransfer bankTransfer;

    @Mock
    FindAccountPort findAccountPort;

    @Mock
    SaveAccountPort saveAccountPort;

    Account originAccount;
    Account destinyAccount;

    @BeforeEach
    void setUp(){
        originAccount = Account.builder().id(ORIGIN_ACCOUNT_ID).balance(BigDecimal.valueOf(100)).build();
        destinyAccount = Account.builder().id(DESTINY_ACCOUNT_ID).balance(BigDecimal.valueOf(100)).build();
    }

    @Test
    void shouldTransferSuccessWhenAllParamtersAreValid(){
        var optOriginAccount = Optional.of(originAccount);
        var optDestinyAccount = Optional.of(destinyAccount);
        when(findAccountPort.findById(ORIGIN_ACCOUNT_ID)).thenReturn(optOriginAccount);
        when(findAccountPort.findById(DESTINY_ACCOUNT_ID)).thenReturn(optDestinyAccount);

        bankTransfer.transfer(ORIGIN_ACCOUNT_ID, DESTINY_ACCOUNT_ID, BigDecimal.valueOf(1));

        verify(saveAccountPort, times(2)).save(any(Account.class));
    }

    @Test
    void shouldTransferFailWhenTryToTheSameAccount(){
        var optOriginAccount = Optional.of(originAccount);

        when(findAccountPort.findById(ORIGIN_ACCOUNT_ID)).thenReturn(optOriginAccount);
        when(findAccountPort.findById(DESTINY_ACCOUNT_ID)).thenReturn(optOriginAccount);

        SameAccountTransferException thrown = Assertions.assertThrows(SameAccountTransferException.class, () -> {
            bankTransfer.transfer(ORIGIN_ACCOUNT_ID, DESTINY_ACCOUNT_ID, BigDecimal.valueOf(1));
        });

        Assertions.assertEquals("Can't transfer to the same account", thrown.getMessage());
        verify(saveAccountPort, times(0)).save(any(Account.class));
    }

    @Test
    void shouldTransferFailWhenAccountDoesNotFound(){
        var optOriginAccount = Optional.of(originAccount);

        when(findAccountPort.findById(ORIGIN_ACCOUNT_ID)).thenReturn(optOriginAccount);
        when(findAccountPort.findById(DESTINY_ACCOUNT_ID)).thenReturn(Optional.empty());

        BankTransferException thrown = Assertions.assertThrows(BankTransferException.class, () -> {
            bankTransfer.transfer(ORIGIN_ACCOUNT_ID, DESTINY_ACCOUNT_ID, BigDecimal.valueOf(1));
        });

        Assertions.assertEquals("Error in transfer, check accounts data.", thrown.getMessage());
        verify(saveAccountPort, times(0)).save(any(Account.class));
    }
}
