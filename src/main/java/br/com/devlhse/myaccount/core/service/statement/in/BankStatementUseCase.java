package br.com.devlhse.myaccount.core.service.statement.in;

import br.com.devlhse.myaccount.core.domain.entity.Transaction;

import java.util.List;

public interface BankStatementUseCase {

    List<Transaction> getStatement(Long accountId);
}
