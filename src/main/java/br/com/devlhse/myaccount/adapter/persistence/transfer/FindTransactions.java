package br.com.devlhse.myaccount.adapter.persistence.transfer;

import br.com.devlhse.myaccount.adapter.persistence.transfer.mapper.TransactionMapper;
import br.com.devlhse.myaccount.core.domain.entity.Transaction;
import br.com.devlhse.myaccount.core.service.statement.out.FindTransactionsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FindTransactions implements FindTransactionsPort {

    private final TransactionRepository repository;

    @Override
    public List<Transaction> findByAccountId(Long accountId) {
        return repository.findByAccountId(accountId)
                .stream()
                .map(TransactionMapper::toDomain)
                .collect(Collectors.toList());
    }
}
