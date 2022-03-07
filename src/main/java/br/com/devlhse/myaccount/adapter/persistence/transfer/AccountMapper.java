package br.com.devlhse.myaccount.adapter.persistence.transfer;

import br.com.devlhse.myaccount.core.domain.transfer.Account;

public class AccountMapper {

    static Account toDomain(AccountModel accountModel) {
        return Account.builder()
                .id(accountModel.getId())
                .balance(accountModel.getBalance())
                .build();
    }

    static AccountModel toPersistenceModel(Account account) {
        return AccountModel.builder()
                .id(account.getId())
                .balance(account.getBalance())
                .build();
    }
}
