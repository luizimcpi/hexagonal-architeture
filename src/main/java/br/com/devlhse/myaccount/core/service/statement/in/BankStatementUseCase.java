package br.com.devlhse.myaccount.core.service.statement.in;

import br.com.devlhse.myaccount.core.service.statement.entity.Statement;

public interface BankStatementUseCase {

    Statement getStatement(Long accountId);
}
