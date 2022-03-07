package br.com.devlhse.myaccount.core.domain.transfer.exception;

public class BankTransferException extends RuntimeException {
    public BankTransferException(String message) {
        super(message);
    }
}
