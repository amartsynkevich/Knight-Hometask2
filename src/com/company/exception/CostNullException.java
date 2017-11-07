package com.company.exception;

public class CostNullException extends Exception {
    public CostNullException(String message) {
        super(message);
    }

    public CostNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
