package com.product.catalog.service;

import com.product.catalog.entity.ProductData;
import com.product.catalog.model.ProductRequestPayload;

public interface ProductCatalogService {


    public ProductData addProduct(ProductRequestPayload product);

}
