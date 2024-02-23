package com.demo.aliens.controllers;

import com.demo.aliens.exceptions.AlienSystemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleAlienException(MethodArgumentNotValidException exception) {
        StringBuilder errorMessage = new StringBuilder("Validation errors:");

        BindingResult bindingResult = exception.getBindingResult();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String fieldName = fieldError.getField();
            String errorMessageText = fieldError.getDefaultMessage();
            errorMessage.append("\n").append(fieldName).append(": ").append(errorMessageText);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorMessage.toString());
    }

    @ExceptionHandler({AlienSystemException.class, Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleAlienException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }

}
