package br.com.devlhse.myaccount.core.service.statement;

import br.com.devlhse.myaccount.core.domain.entity.Transaction;
import br.com.devlhse.myaccount.core.domain.statement.exception.TransactionsNotFoundException;
import br.com.devlhse.myaccount.core.service.statement.in.BankStatementUseCase;
import br.com.devlhse.myaccount.core.service.statement.out.FindTransactionsPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class BankStatement implements BankStatementUseCase {

    private final FindTransactionsPort findTransactionsPort;

    @Override
    public List<Transaction> getStatement(Long accountId) {
        var transactions = findTransactionsPort.findByAccountId(accountId);
        if(transactions == null || transactions.isEmpty()){
            log.warn("Bank Statement error, empty transactions for accountId: {}", accountId);
            throw new TransactionsNotFoundException("Can´t found transactions for id: " + accountId);
        }
        return transactions;
    }
}
