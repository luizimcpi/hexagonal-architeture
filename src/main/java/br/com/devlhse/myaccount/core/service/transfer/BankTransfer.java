package br.com.devlhse.myaccount.core.service.transfer;

import br.com.devlhse.myaccount.core.domain.entity.Account;
import br.com.devlhse.myaccount.core.domain.entity.Transaction;
import br.com.devlhse.myaccount.core.domain.transfer.exception.BankTransferException;
import br.com.devlhse.myaccount.core.domain.transfer.exception.SameAccountTransferException;
import br.com.devlhse.myaccount.core.service.transfer.in.BankTransferUseCase;
import br.com.devlhse.myaccount.core.service.transfer.out.FindAccountPort;
import br.com.devlhse.myaccount.core.service.transfer.out.SaveTransactionPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class BankTransfer implements BankTransferUseCase {

    private final FindAccountPort findAccountPort;
    private final SaveTransactionPort saveTransactionPort;

    @Transactional
    @Override
    public void transfer(Long originAccountId, Long destinyAccountId, BigDecimal amount) {
        try {
            Optional<Account> originAccount = findAccountPort.findById(originAccountId);
            Optional<Account> destinyAccount = findAccountPort.findById(destinyAccountId);

            if(originAccount.get().getId().equals(destinyAccount.get().getId())) {
                throw new SameAccountTransferException("Can't transfer to the same account");
            }

            Transaction originDebitTransaction = originAccount.get().debit(amount);
            Transaction destinyCreditTransaction = destinyAccount.get().credit(amount);

            saveTransactionPort.save(originDebitTransaction);
            saveTransactionPort.save(destinyCreditTransaction);

        } catch (SameAccountTransferException e) {
            log.warn("Bank Transfer error: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Bank Transfer error: {}", e.getMessage());
            throw new BankTransferException("Error in transfer, check accounts data.");
        }
    }
}
