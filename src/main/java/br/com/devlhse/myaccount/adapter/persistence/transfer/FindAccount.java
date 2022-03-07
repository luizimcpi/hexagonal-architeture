package br.com.devlhse.myaccount.adapter.persistence.transfer;

import br.com.devlhse.myaccount.core.domain.Account;
import br.com.devlhse.myaccount.core.service.transfer.out.FindAccountPort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class FindAccount implements FindAccountPort {

    private final AccountRepository repository;

    @Override
    public Optional<Account> findById(Long id) {
        return repository.findById(id)
                .map(AccountMapper::toDomain);
    }
}
