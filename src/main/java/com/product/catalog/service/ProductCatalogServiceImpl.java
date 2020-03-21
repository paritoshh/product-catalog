package com.product.catalog.service;

import com.product.catalog.entity.TelevisionData;
import com.product.catalog.mapper.ElectronicsMapper;
import com.product.catalog.model.InventoryResponse;
import com.product.catalog.model.Product;
import com.product.catalog.model.ProductRequestPayload;
import com.product.catalog.model.Television;
import com.product.catalog.util.ProductFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

    @Autowired
    ProductFactory productFactory;
    @Autowired
    ElectronicsMapper electronicsMapper;

    @Override
    public InventoryResponse addProduct(ProductRequestPayload product) {
        Product productDetailsInRequest = productFactory.getProductObject(product);
        TelevisionData tvData = electronicsMapper.mapTelevision((Television) productDetailsInRequest);
        productDetailsInRequest.getJpaRepository().save(tvData);
        //productDetailsInRequest.getUpdateService().addProduct(productDetailsInRequest);
        return null;
    }


}