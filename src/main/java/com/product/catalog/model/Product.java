package com.product.catalog.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private String serialNumber;
    private String brand;
    private String price;
    private String productType;
    private String description;
}
