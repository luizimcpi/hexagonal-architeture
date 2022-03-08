package br.com.devlhse.myaccount.core.service.transfer.out;

import br.com.devlhse.myaccount.core.domain.entity.Transaction;

public interface SaveTransactionPort {

    Transaction save(Transaction transaction);
}
