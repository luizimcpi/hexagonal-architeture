package br.com.devlhse.myaccount.adapter.persistence.transfer;

import br.com.devlhse.myaccount.core.domain.transfer.Account;
import br.com.devlhse.myaccount.core.service.transfer.out.SaveAccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveAccount implements SaveAccountPort {

    private final AccountRepository repository;


    @Override
    public Account save(Account account) {
        return AccountMapper.toDomain(repository.save(AccountMapper.toPersistenceModel(account)));
    }
}
