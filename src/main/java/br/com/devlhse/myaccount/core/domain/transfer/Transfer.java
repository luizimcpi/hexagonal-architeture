package br.com.devlhse.myaccount.core.domain.transfer;

import br.com.devlhse.myaccount.core.domain.Account;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class Transfer {

    private Account originAccount;
    private Account destinyAccount;
    private BigDecimal value;

    public void doIt() {
        originAccount.debit(this.value);
        destinyAccount.credit(this.value);
    }
}
