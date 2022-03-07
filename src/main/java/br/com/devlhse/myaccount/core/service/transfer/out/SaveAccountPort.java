package br.com.devlhse.myaccount.core.service.transfer.out;

import br.com.devlhse.myaccount.core.domain.transfer.Account;

public interface SaveAccountPort {

    Account save(Account account);
}
