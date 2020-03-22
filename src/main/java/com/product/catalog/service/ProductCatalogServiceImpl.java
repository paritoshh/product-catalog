package com.product.catalog.service;

import com.product.catalog.entity.ProductData;
import com.product.catalog.mapper.ElectronicsMapper;
import com.product.catalog.model.ProductRequestPayload;
import com.product.catalog.repository.ProductRepository;
import com.product.catalog.util.ProductFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

    @Autowired
    ProductFactory productFactory;
    @Autowired
    ElectronicsMapper electronicsMapper;
    @Autowired
    ProductRepository repository;


    @Override
    public ProductData addProduct(ProductRequestPayload product) {
        ProductData productDetailsInRequest = productFactory.getProductObject(product);
        return repository.save(productDetailsInRequest);
    }

    @Override
    public List<ProductData> fetchAll() {
        List<ProductData> productsInDB = repository.findAll();
        return productsInDB;
    }
}