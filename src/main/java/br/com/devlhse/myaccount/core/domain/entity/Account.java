package br.com.devlhse.myaccount.core.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@AllArgsConstructor
@Getter
@Builder
public class Account {

    private Long id;

    public Transaction debit(final BigDecimal amount) {
        return Transaction.builder()
                .transactionType(TransactionType.DEBIT)
                .account(this)
                .createdAt(LocalDateTime.now())
                .amount(amount)
                .build();
    }

    public Transaction credit(BigDecimal amount) {
        return Transaction.builder()
                .transactionType(TransactionType.CREDIT)
                .account(this)
                .createdAt(LocalDateTime.now())
                .amount(amount)
                .build();
    }

}
