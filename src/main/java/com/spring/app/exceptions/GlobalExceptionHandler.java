package com.spring.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> resourceNotFoundExceptionHandler(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails exception = ErrorDetails.builder().status("Not Found").timestamp(new Date()).message(ex.getMessage()).details(request.getDescription(false)).build();
        return new  ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDetails> badRequestExceptionHandler(BadRequestException ex, WebRequest request) {
        ErrorDetails exception = ErrorDetails.builder().status("Bad Request").timestamp(new Date()).message(ex.getMessage()).details(request.getDescription(false)).build();
        return new  ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}