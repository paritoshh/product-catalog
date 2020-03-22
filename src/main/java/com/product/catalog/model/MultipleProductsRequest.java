package com.product.catalog.model;

import lombok.Getter;

import javax.validation.constraints.Size;
import java.util.List;

@Getter
public class MultipleProductsRequest {
    @Size(min = 1, max = 20, message = "Maximum 20 products can be added together.")
    List<ProductRequestPayload> products;
}