package com.tcs.practise.employeeapp.exceptionHandling;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ExceptionResponse {
    private String message;
    private LocalDateTime dateTime;
}
