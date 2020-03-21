package com.product.catalog.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ProductRequestPayload {

    public String productType;
    public String payload;
}
