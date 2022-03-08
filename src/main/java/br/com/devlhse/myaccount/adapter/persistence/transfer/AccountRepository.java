package br.com.devlhse.myaccount.adapter.persistence.transfer;

import br.com.devlhse.myaccount.adapter.persistence.transfer.entity.AccountModel;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountModel, Long> {
}
