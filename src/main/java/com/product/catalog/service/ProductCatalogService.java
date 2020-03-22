package com.product.catalog.service;

import com.product.catalog.entity.ProductData;
import com.product.catalog.model.ProductRequestPayload;

import java.util.List;

public interface ProductCatalogService {


    ProductData addProduct(ProductRequestPayload product);
    List<ProductData> fetchAll();

}
