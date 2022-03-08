package br.com.devlhse.myaccount.core.service.statement;

import br.com.devlhse.myaccount.core.domain.entity.Transaction;
import br.com.devlhse.myaccount.core.domain.entity.TransactionType;
import br.com.devlhse.myaccount.core.domain.statement.exception.TransactionsNotFoundException;
import br.com.devlhse.myaccount.core.service.statement.entity.Statement;
import br.com.devlhse.myaccount.core.service.statement.in.BankStatementUseCase;
import br.com.devlhse.myaccount.core.service.statement.out.FindTransactionsPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class BankStatement implements BankStatementUseCase {

    private final FindTransactionsPort findTransactionsPort;

    @Override
    public Statement getStatement(Long accountId) {
        var transactions = findTransactionsPort.findByAccountId(accountId);
        if(transactions == null || transactions.isEmpty()){
            log.warn("Bank Statement error, empty transactions for accountId: {}", accountId);
            throw new TransactionsNotFoundException("Can´t found transactions for id: " + accountId);
        }
        return Statement.builder()
                .balance(getBalance(transactions))
                .transactions(transactions)
                .build();
    }

    public BigDecimal getBalance(List<Transaction> transactions){
        var totalDebit = getTotalByTransactionType(transactions, TransactionType.DEBIT);
        var totalCredit = getTotalByTransactionType(transactions, TransactionType.CREDIT);

        return totalCredit.subtract(totalDebit);
    }

    private BigDecimal getTotalByTransactionType(List<Transaction> transactions, TransactionType transactionType) {
        BigDecimal total = BigDecimal.ZERO;
        for(Transaction transaction : transactions) {
            if(transactionType.equals(transaction.getTransactionType())) {
                total = total.add(transaction.getAmount());
            }
        }
        return total;
    }
}
