package br.com.devlhse.myaccount.core.service.transfer.out;

import br.com.devlhse.myaccount.core.domain.transfer.Account;

import java.util.Optional;

public interface FindAccountPort {

    Optional<Account> findById(Long id);
}
