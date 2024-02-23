package com.demo.aliens.controllers;

import com.demo.aliens.beans.AlienBean;
import com.demo.aliens.exceptions.AlienErrMsg;
import com.demo.aliens.exceptions.AlienSystemException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    void testHandleAlienSystemException() {

        AlienSystemException exception = new AlienSystemException(AlienErrMsg.INVALID_COMMANDER_ID);

        ResponseEntity<String> responseEntity = globalExceptionHandler.handleAlienException(exception);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        assertEquals(AlienErrMsg.INVALID_COMMANDER_ID.getValue(), responseEntity.getBody());
    }

}

