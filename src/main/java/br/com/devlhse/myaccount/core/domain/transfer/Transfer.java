package br.com.devlhse.myaccount.core.domain.transfer;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class Transfer {

    private Account originAccount;
    private Account destinyAccount;
    private BigDecimal value;

    public void transferir() {
        originAccount.debit(this.value);
        destinyAccount.credit(this.value);
    }
}
