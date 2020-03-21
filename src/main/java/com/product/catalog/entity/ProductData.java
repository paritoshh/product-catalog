package com.product.catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class ProductData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SNO", nullable = false)
    private final String serialNumber;
    @Column(name = "BRAND", nullable = false)
    private final String brand;
    @Column(name = "PRICE", nullable = false)
    private final String price;
}
