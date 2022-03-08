package br.com.devlhse.myaccount.adapter.persistence.transfer.mapper;

import br.com.devlhse.myaccount.adapter.persistence.transfer.entity.AccountModel;
import br.com.devlhse.myaccount.core.domain.entity.Account;

public class AccountMapper {

    public static Account toDomain(AccountModel accountModel) {
        return Account.builder()
                .id(accountModel.getId())
                .build();
    }

    public static AccountModel toPersistenceModel(Account account) {
        return AccountModel.builder()
                .id(account.getId())
                .build();
    }
}
