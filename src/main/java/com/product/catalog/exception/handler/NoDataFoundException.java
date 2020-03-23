package com.product.catalog.exception.handler;

/**
 * This is a custom exception.
 */
public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException(String message) {
        super(message);
    }
}
