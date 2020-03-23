package com.product.catalog.repository;

import com.product.catalog.entity.ProductData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductData, Integer> {

    List<ProductData> findByBrand(String brand);
}