package br.com.devlhse.myaccount.core.service.transfer;

import br.com.devlhse.myaccount.core.domain.transfer.Account;
import br.com.devlhse.myaccount.core.service.transfer.in.BankTransferUseCase;
import br.com.devlhse.myaccount.core.service.transfer.out.FindAccountPort;
import br.com.devlhse.myaccount.core.service.transfer.out.SaveAccountPort;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Optional;

@RequiredArgsConstructor
public class BankTransfer implements BankTransferUseCase {

    private final FindAccountPort findAccountPort;
    private final SaveAccountPort saveAccountPort;

    @Override
    public void transfer(Long originAccountId, Long destinyAccountId, BigDecimal value) {
        try {
            Optional<Account> originAccount = findAccountPort.findById(originAccountId);
            Optional<Account> destinyAccount = findAccountPort.findById(destinyAccountId);
        } catch (Exception e) {
            throw e;
        }
    }
}
