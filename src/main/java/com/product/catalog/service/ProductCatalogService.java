package com.product.catalog.service;

import com.product.catalog.model.InventoryResponse;
import com.product.catalog.model.ProductRequestPayload;

public interface ProductCatalogService {


    public InventoryResponse addProduct(ProductRequestPayload product);

}
