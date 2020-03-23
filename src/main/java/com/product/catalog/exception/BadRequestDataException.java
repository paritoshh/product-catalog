package com.product.catalog.exception;

/**
 * This is a custom exception.
 */
public class BadRequestDataException extends RuntimeException {
    public BadRequestDataException(String message) {
        super(message);
    }
}
