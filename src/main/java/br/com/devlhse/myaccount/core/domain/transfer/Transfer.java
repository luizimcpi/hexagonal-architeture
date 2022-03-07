package br.com.devlhse.myaccount.core.domain.transfer;

import br.com.devlhse.myaccount.core.domain.transfer.exception.SameAccountTransferException;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class Transfer {

    private Account originAccount;
    private Account destinyAccount;
    private BigDecimal value;

    public void doIt() {
        if(this.originAccount.getId().equals(this.destinyAccount.getId())) {
            throw new SameAccountTransferException("Can't transfer to the same account");
        }
        originAccount.debit(this.value);
        destinyAccount.credit(this.value);
    }
}
