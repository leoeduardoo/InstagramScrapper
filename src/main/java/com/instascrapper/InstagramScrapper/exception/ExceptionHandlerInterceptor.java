package com.instascrapper.InstagramScrapper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerInterceptor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public final ResponseEntity<Object> objectNotFoundException(ObjectNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomExceptionSchema(ex.getMessage()));
    }

    @ExceptionHandler(DuplicatedRegisterException.class)
    public final ResponseEntity<Object> duplicatedRegisterException(DuplicatedRegisterException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new CustomExceptionSchema(ex.getMessage()));
    }

    @ExceptionHandler(InvalidObjectException.class)
    public final ResponseEntity<Object> invalidObjectException(InvalidObjectException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomExceptionSchema(ex.getMessage()));
    }

    @ExceptionHandler(NotSameUsername.class)
    public final ResponseEntity<Object> notSameUsername(NotSameUsername ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomExceptionSchema(ex.getMessage()));
    }

}