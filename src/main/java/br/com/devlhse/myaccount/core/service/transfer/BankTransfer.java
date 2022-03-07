package br.com.devlhse.myaccount.core.service.transfer;

import br.com.devlhse.myaccount.core.domain.Account;
import br.com.devlhse.myaccount.core.domain.transfer.Transfer;
import br.com.devlhse.myaccount.core.service.transfer.in.BankTransferUseCase;
import br.com.devlhse.myaccount.core.service.transfer.out.FindAccountPort;
import br.com.devlhse.myaccount.core.service.transfer.out.SaveAccountPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
public class BankTransfer implements BankTransferUseCase {

    private final FindAccountPort findAccountPort;
    private final SaveAccountPort saveAccountPort;

    @Override
    public void transfer(Long originAccountId, Long destinyAccountId, BigDecimal value) {
        try {
            Optional<Account> originAccount = findAccountPort.findById(originAccountId);
            Optional<Account> destinyAccount = findAccountPort.findById(destinyAccountId);

            Transfer transfer = new Transfer(originAccount.get(), destinyAccount.get(), value);
            transfer.doIt();

            saveAccountPort.save(originAccount.get());
            saveAccountPort.save(destinyAccount.get());
        } catch (Exception e) {
            log.error("Transfer error: {}", e.getMessage());
            throw e;
        }
    }
}
