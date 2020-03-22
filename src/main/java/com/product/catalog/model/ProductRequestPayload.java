package com.product.catalog.model;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class ProductRequestPayload {

    @NotBlank(message = "Product type must be defined to add any product.")
    @Pattern(regexp = "[a-zA-Z0-9_-]{1,15}")
    public String productType;
    @NotBlank(message = "Product details must be provided to add any product.")
    public String payload;
}
