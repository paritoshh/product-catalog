package com.product.catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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

}
