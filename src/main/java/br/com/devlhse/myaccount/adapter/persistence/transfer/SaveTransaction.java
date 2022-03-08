package br.com.devlhse.myaccount.adapter.persistence.transfer;

import br.com.devlhse.myaccount.adapter.persistence.transfer.mapper.TransactionMapper;
import br.com.devlhse.myaccount.core.domain.entity.Transaction;
import br.com.devlhse.myaccount.core.service.transfer.out.SaveTransactionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveTransaction implements SaveTransactionPort {

    private final TransactionRepository repository;


    @Override
    public Transaction save(Transaction transaction) {
        return TransactionMapper.toDomain(repository.save(TransactionMapper.toPersistenceModel(transaction)));
    }
}
