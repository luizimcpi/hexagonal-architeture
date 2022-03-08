package br.com.devlhse.myaccount.adapter.web.statement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatementOutput {

    private BigDecimal balance;
    private List<TransactionOutput> transactions;
}
