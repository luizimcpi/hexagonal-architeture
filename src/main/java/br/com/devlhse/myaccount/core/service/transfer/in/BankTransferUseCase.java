package br.com.devlhse.myaccount.core.service.transfer.in;

import java.math.BigDecimal;

public interface BankTransferUseCase {

    void transfer(Long originAccountId, Long destinyAccountId, BigDecimal value);
}
