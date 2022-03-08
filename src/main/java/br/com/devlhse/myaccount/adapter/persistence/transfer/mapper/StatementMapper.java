package br.com.devlhse.myaccount.adapter.persistence.transfer.mapper;

import br.com.devlhse.myaccount.adapter.web.statement.dto.StatementOutput;
import br.com.devlhse.myaccount.core.service.statement.entity.Statement;

import java.util.stream.Collectors;

public class StatementMapper {

    public static StatementOutput toOutput(Statement statement) {
        return StatementOutput.builder()
                .balance(statement.getBalance())
                .transactions(statement.getTransactions()
                        .stream()
                        .map(TransactionMapper::toOutput)
                        .collect(Collectors.toList()))
                .build();
    }

}
