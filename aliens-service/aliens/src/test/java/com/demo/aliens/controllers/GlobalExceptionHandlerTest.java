package com.demo.aliens.controllers;

import com.demo.aliens.exceptions.AlienErrMsg;
import com.demo.aliens.exceptions.AlienSystemException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;


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

