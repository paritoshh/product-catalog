package com.product.catalog.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Table(name="Products")
public class ProductData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SNO", nullable = false)
    private String serialNumber;
    @Column(name = "BRAND", nullable = false)
    private String brand;
    @Column(name = "PRICE", nullable = false)
    private String price;
    @Column(name = "DESC", nullable = false)
    private String description;
    @Column(name = "PRODUCT_TYPE", nullable = false)
    private String productType;

}
