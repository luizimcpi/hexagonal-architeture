package br.com.devlhse.myaccount.core.domain.transfer.exception;

public class SameAccountTransferException extends RuntimeException {
    public SameAccountTransferException(String message) {
        super(message);
    }
}
