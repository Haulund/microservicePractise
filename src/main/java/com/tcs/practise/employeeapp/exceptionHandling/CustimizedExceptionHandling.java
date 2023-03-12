package com.tcs.practise.employeeapp.exceptionHandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustimizedExceptionHandling extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(TransactionSystemException.class)
    public ResponseEntity<Object> handleExceptions(TransactionSystemException exception, WebRequest req) {
        ExceptionResponse res = new ExceptionResponse( "Need BODY", LocalDateTime.now());
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }
}
