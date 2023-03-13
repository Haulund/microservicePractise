package com.tcs.practise.employeeapp.exceptionHandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Global exception handler!!
@ControllerAdvice
public class CustimizedExceptionHandling extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(TransactionSystemException.class)
    public ResponseEntity<Object> TransactionSystemException(TransactionSystemException exception, WebRequest req) {
        ExceptionResponse res = new ExceptionResponse( "fields not null", LocalDateTime.now());
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> EmployeeNotFoundException(EmployeeNotFoundException exception, WebRequest req){
        ExceptionResponse res = new ExceptionResponse("Employee not found", LocalDateTime.now());
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }
}
