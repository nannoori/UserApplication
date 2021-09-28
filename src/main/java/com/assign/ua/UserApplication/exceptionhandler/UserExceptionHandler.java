package com.assign.ua.UserApplication.exceptionhandler;

import com.assign.ua.UserApplication.exception.UserNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleNonExistingUser(UserNotFoundException exception) {
        return new ResponseEntity<>("User not found", HttpStatus.BAD_GATEWAY);
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleNonExistingUser(EmptyResultDataAccessException exception) {
        return new ResponseEntity<>("User not found", HttpStatus.BAD_GATEWAY);
    }
}
