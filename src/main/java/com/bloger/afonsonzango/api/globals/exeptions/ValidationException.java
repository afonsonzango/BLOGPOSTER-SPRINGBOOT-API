package com.bloger.afonsonzango.api.globals.exeptions;

public class ValidationException extends RuntimeException {
    public ValidationException (String message) {
        super(message);
    }
}