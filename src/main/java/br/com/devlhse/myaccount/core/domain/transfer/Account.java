package br.com.devlhse.myaccount.core.domain.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;


@AllArgsConstructor
@Getter
@Builder
public class Account {

    private Long id;
    private BigDecimal balance;

    public void debit(BigDecimal value) {
        this.balance = this.balance.subtract(value);
    }

    public void credit(BigDecimal value) {
        this.balance = this.balance.add(value);
    }

}
