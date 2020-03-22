package com.product.catalog.exception;

public class BadRequestDataException extends RuntimeException {
    public BadRequestDataException(String message){
        super(message);
    }
}
