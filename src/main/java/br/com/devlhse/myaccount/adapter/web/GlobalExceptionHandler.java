package br.com.devlhse.myaccount.adapter.web;

import br.com.devlhse.myaccount.core.domain.statement.exception.TransactionsNotFoundException;
import br.com.devlhse.myaccount.core.domain.transfer.exception.BankTransferException;
import br.com.devlhse.myaccount.core.domain.transfer.exception.SameAccountTransferException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BankTransferException.class)
    public ResponseEntity<ErrorMessageResponse> handleBankTransferException(Exception e) {
        return new ResponseEntity<>(getErrorMessageResponse(e), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SameAccountTransferException.class)
    public ResponseEntity<ErrorMessageResponse> handleSameAccountTransferException(Exception e) {
        return new ResponseEntity<>(getErrorMessageResponse(e), HttpStatus.CONFLICT);
    }


    @ExceptionHandler(TransactionsNotFoundException.class)
    public ResponseEntity<ErrorMessageResponse> handleTransactionsNotFoundException(Exception e) {
        return new ResponseEntity<>(getErrorMessageResponse(e), HttpStatus.NO_CONTENT);
    }

    private ErrorMessageResponse getErrorMessageResponse(Exception e) {
        ErrorMessageResponse errorMessage = new ErrorMessageResponse();
        errorMessage.setMessage(e.getMessage());
        return errorMessage;
    }
}

class ErrorMessageResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}