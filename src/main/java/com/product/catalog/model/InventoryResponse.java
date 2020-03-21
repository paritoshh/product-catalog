package com.product.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class InventoryResponse {
    String code;
    String message;
}

