package com.product.catalog.model;

import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;

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
    JpaRepository jpaRepository;
}
