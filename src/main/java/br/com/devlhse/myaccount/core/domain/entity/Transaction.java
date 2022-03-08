package br.com.devlhse.myaccount.core.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@AllArgsConstructor
@Getter
@Builder
public class Transaction {

    private UUID id;
    private Account account;
    private LocalDateTime createdAt;
    private BigDecimal amount;
    private TransactionType transactionType;

}
