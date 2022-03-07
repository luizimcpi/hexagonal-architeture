package br.com.devlhse.myaccount.core.domain.transfer;

import br.com.devlhse.myaccount.core.domain.transfer.exception.SameAccountTransferException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferTest {

    public static final long ORIGIN_ACCOUNT_ID = 1L;
    public static final long DESTINY_ACCOUNT_ID = 2L;
    Account originAccount;
    Account destinyAccount;
    Transfer transfer;

    @Test
    void shouldTransferWithSuccess(){
        originAccount = Account.builder().id(ORIGIN_ACCOUNT_ID).balance(BigDecimal.valueOf(100)).build();
        destinyAccount = Account.builder().id(DESTINY_ACCOUNT_ID).balance(BigDecimal.valueOf(100)).build();
        transfer = new Transfer(originAccount, destinyAccount, BigDecimal.valueOf(50));
        transfer.doIt();
        assertEquals(BigDecimal.valueOf(50), originAccount.getBalance());
        assertEquals(BigDecimal.valueOf(150), destinyAccount.getBalance());
    }


    @Test
    void shouldReturnErrorWhenSameAccountInstance(){
        originAccount = Account.builder().id(ORIGIN_ACCOUNT_ID).balance(BigDecimal.valueOf(100)).build();
        transfer = new Transfer(originAccount, originAccount, BigDecimal.valueOf(50));
        SameAccountTransferException thrown = Assertions.assertThrows(SameAccountTransferException.class, () -> {
            transfer.doIt();
        });

        Assertions.assertEquals("Can't transfer to the same account", thrown.getMessage());
    }

    @Test
    void shouldReturnErrorWhenSameAccountId(){
        originAccount = Account.builder().id(ORIGIN_ACCOUNT_ID).balance(BigDecimal.valueOf(100)).build();
        destinyAccount = Account.builder().id(ORIGIN_ACCOUNT_ID).balance(BigDecimal.valueOf(100)).build();
        transfer = new Transfer(originAccount, destinyAccount, BigDecimal.valueOf(50));

        SameAccountTransferException thrown = Assertions.assertThrows(SameAccountTransferException.class, () -> {
            transfer.doIt();
        });

        Assertions.assertEquals("Can't transfer to the same account", thrown.getMessage());
    }
}
