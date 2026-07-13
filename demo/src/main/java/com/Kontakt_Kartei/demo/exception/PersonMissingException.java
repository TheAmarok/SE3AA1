package com.Kontakt_Kartei.demo.exception;

public class PersonMissingException extends RuntimeException {
    public PersonMissingException(String message) {
        super(message);
    }
}
