package com.product.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class InventoryActionResponse {
    String code;
    String message;
}
