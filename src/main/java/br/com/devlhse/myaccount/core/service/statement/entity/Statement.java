package br.com.devlhse.myaccount.core.service.statement.entity;

import br.com.devlhse.myaccount.core.domain.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class Statement {

    private BigDecimal balance;
    private List<Transaction> transactions;
}
