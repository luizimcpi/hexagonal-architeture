package br.com.devlhse.myaccount.adapter.persistence.transfer.mapper;

import br.com.devlhse.myaccount.adapter.persistence.transfer.entity.TransactionModel;
import br.com.devlhse.myaccount.adapter.persistence.transfer.entity.TransactionTypeModel;
import br.com.devlhse.myaccount.adapter.web.statement.dto.TransactionOutput;
import br.com.devlhse.myaccount.core.domain.entity.Transaction;
import br.com.devlhse.myaccount.core.domain.entity.TransactionType;

public class TransactionMapper {

    public static Transaction toDomain(TransactionModel transactionModel) {
        return Transaction.builder()
                .id(transactionModel.getId())
                .account(AccountMapper.toDomain(transactionModel.getAccountModel()))
                .createdAt(transactionModel.getCreatedAt())
                .amount(transactionModel.getAmount())
                .transactionType(getTransactionType(transactionModel))
                .build();
    }

    private static TransactionType getTransactionType(TransactionModel transactionModel) {
        return TransactionTypeModel.CREDIT.equals(transactionModel.getTransactionTypeModel()) ? TransactionType.CREDIT : TransactionType.DEBIT;
    }

    public static TransactionModel toPersistenceModel(Transaction transaction) {
        return TransactionModel.builder()
                .id(transaction.getId())
                .accountModel(AccountMapper.toPersistenceModel(transaction.getAccount()))
                .createdAt(transaction.getCreatedAt())
                .amount(transaction.getAmount())
                .transactionTypeModel(getTransactionTypeModel(transaction))
                .build();
    }

    private static TransactionTypeModel getTransactionTypeModel(Transaction transaction) {
        return TransactionType.CREDIT.equals(transaction.getTransactionType()) ? TransactionTypeModel.CREDIT : TransactionTypeModel.DEBIT;
    }

    public static TransactionOutput toOutput(Transaction transaction) {
        return TransactionOutput.builder()
                .createdAt(transaction.getCreatedAt())
                .amount(transaction.getAmount())
                .transactionTypeModel(getTransactionTypeModel(transaction))
                .build();
    }
}
