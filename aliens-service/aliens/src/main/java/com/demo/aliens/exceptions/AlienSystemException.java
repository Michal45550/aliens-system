package com.demo.aliens.exceptions;

public class AlienSystemException extends Exception {

    public AlienSystemException(AlienErrMsg message) {
        super(message.getValue());
    }

}
