package com.product.catalog.model;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
public class ProductRequestPayload {

    private static final String PRODUCT_TYPE_REGEX_PATTERN = "[a-zA-Z0-9_-]{1,15}";

    @NotBlank(message = "Product type must be defined to add any product.")
    @Pattern(regexp = PRODUCT_TYPE_REGEX_PATTERN, message = "Product type must follow :"+PRODUCT_TYPE_REGEX_PATTERN)
    public String productType;
    @NotBlank(message = "Product details must be provided to add any product.")
    public String payload;
}
