package br.com.devlhse.myaccount.adapter.persistence.transfer;

import br.com.devlhse.myaccount.adapter.persistence.transfer.entity.TransactionModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends CrudRepository<TransactionModel, Long> {

    @Query(value =
            "select t from TransactionModel t join t.accountModel u" +
                    " WHERE u.id = :accountId")
    List<TransactionModel> findByAccountId(@Param("accountId") Long accountId);
}
