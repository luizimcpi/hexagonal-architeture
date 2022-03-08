package br.com.devlhse.myaccount.adapter.web.statement.dto;

import br.com.devlhse.myaccount.adapter.persistence.transfer.entity.TransactionTypeModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionOutput {

    private LocalDateTime createdAt;
    private BigDecimal amount;
    private TransactionTypeModel transactionTypeModel;
}
