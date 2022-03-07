package br.com.devlhse.myaccount.adapter.persistence.transfer;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountModel, Long> {
}
