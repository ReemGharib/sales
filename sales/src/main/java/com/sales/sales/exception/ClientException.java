package com.sales.sales.exception;

public class ClientException extends RuntimeException {

    private final String description;

    public ClientException(String message) {
        super(message);
        this.description = null;
    }
}
