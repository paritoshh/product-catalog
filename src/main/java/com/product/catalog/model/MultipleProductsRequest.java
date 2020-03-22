package com.product.catalog.model;

import lombok.Getter;

import java.util.List;

@Getter
public class MultipleProductsRequest {
    List<ProductRequestPayload> products;
}