package br.com.devlhse.myaccount.core.service.transfer;

import br.com.devlhse.myaccount.core.domain.transfer.Account;
import br.com.devlhse.myaccount.core.domain.transfer.Transfer;
import br.com.devlhse.myaccount.core.domain.transfer.exception.BankTransferException;
import br.com.devlhse.myaccount.core.domain.transfer.exception.SameAccountTransferException;
import br.com.devlhse.myaccount.core.service.transfer.in.BankTransferUseCase;
import br.com.devlhse.myaccount.core.service.transfer.out.FindAccountPort;
import br.com.devlhse.myaccount.core.service.transfer.out.SaveAccountPort;
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
    private final SaveAccountPort saveAccountPort;

    @Transactional
    @Override
    public void transfer(Long originAccountId, Long destinyAccountId, BigDecimal value) {
        try {
            Optional<Account> originAccount = findAccountPort.findById(originAccountId);
            Optional<Account> destinyAccount = findAccountPort.findById(destinyAccountId);

            Transfer transfer = new Transfer(originAccount.get(), destinyAccount.get(), value);
            transfer.doIt();

            saveAccountPort.save(originAccount.get());
            saveAccountPort.save(destinyAccount.get());
        } catch (SameAccountTransferException e) {
            log.error("Bank Transfer error: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Bank Transfer error: {}", e.getMessage());
            throw new BankTransferException("Error in transfer, check accounts data.");
        }
    }
}
