package br.com.devlhse.myaccount.core.service.statement.out;

import br.com.devlhse.myaccount.core.domain.entity.Transaction;

import java.util.List;

public interface FindTransactionsPort {

    List<Transaction> findByAccountId(Long accountId);
}
