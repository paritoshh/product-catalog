package com.product.catalog.mapper;

import com.product.catalog.entity.ProductData;
import com.product.catalog.model.Product;

public class UpdateProductResponseMapper {

    public ProductData mapUpdateProductRequestToDataModel(ProductData existingDetails, Product updatedDetails){
        existingDetails.setBrand(updatedDetails.getBrand());
        existingDetails.setPrice(updatedDetails.getPrice());
        existingDetails.setSerialNumber(updatedDetails.getSerialNumber());
        //existingDetails.set
        return null;
    }
}
