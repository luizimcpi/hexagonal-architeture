package br.com.devlhse.myaccount.core.domain.statement.exception;

public class TransactionsNotFoundException extends RuntimeException {
    public TransactionsNotFoundException(String message) {
        super(message);
    }
}
