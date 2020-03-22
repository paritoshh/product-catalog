package com.product.catalog.service;

import com.product.catalog.entity.ProductData;
import com.product.catalog.exception.BadRequestDataException;
import com.product.catalog.mapper.ElectronicsMapper;
import com.product.catalog.model.InventoryActionResponse;
import com.product.catalog.model.MultipleProductsRequest;
import com.product.catalog.model.ProductRequestPayload;
import com.product.catalog.repository.ProductRepository;
import com.product.catalog.util.ProductFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public List<ProductData> addAllProducts(MultipleProductsRequest products) {
        List<ProductData> productsData = new ArrayList<>();
        products.getProducts().stream().forEach(product->{
            productsData.add(productFactory.getProductObject(product));
        });
        //ProductData productDetailsInRequest = productFactory.getProductObject(product);
        return repository.saveAll(productsData);
    }

    @Override
    public List<ProductData> fetchAll() {
        return repository.findAll();
    }

    @Override
    public ProductData findProductForId(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<ProductData> findProductsForBrand(String brand) {
        return repository.findByBrand(brand);
    }

    @Override
    public InventoryActionResponse deleteProduct(Integer id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return InventoryActionResponse.builder()
                    .code("ERR-101")
                    .message("Product not found with the id: "+id)
                    .build();
        }
        return InventoryActionResponse.builder()
                .code("")
                .message("Product deleted successfully.")
                .build();
    }

    @Override
    public ProductData updateProduct(Integer id, ProductRequestPayload updatedProduct) {
        Optional<ProductData> existingDetails = repository.findById(id);
        if(!existingDetails.isPresent()){
            throw new BadRequestDataException(
                    new StringBuilder("No record found for product id:").append(id).toString());
        }
        ProductData productDetailsInRequest = productFactory.getProductObject(updatedProduct);
        productDetailsInRequest.setId(id);
        return repository.save(productDetailsInRequest);

    }
}