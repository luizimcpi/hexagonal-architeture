package br.com.devlhse.myaccount.core.domain.transfer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    Account account;

    @BeforeEach
    void setUp(){
        account = Account.builder().id(1L).balance(BigDecimal.valueOf(100)).build();
    }

    @Test
    void shouldDebitWithSuccess(){
        account.debit(BigDecimal.valueOf(50));
        assertEquals(BigDecimal.valueOf(50), account.getBalance());
    }

    @Test
    void shouldCreditWithSuccess(){
        account.credit(BigDecimal.valueOf(50));
        assertEquals(BigDecimal.valueOf(150), account.getBalance());
    }
}
