package com.product.catalog.service;

import com.google.gson.Gson;
import com.product.catalog.entity.ProductData;
import com.product.catalog.exception.BadRequestDataException;
import com.product.catalog.mapper.ElectronicsMapper;
import com.product.catalog.model.Product;
import com.product.catalog.model.ProductRequestPayload;
import com.product.catalog.model.Television;
import com.product.catalog.model.WashingMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

/**
 * This factory class is pure implementation of 'Factory & Command design patters in Java.
 */
@Service
public class ProductFactory {
    @Autowired
    ElectronicsMapper electronicsMapper;
    @Autowired
    private Validator validator;

    /**
     * This is a factory method, which will identify the type of product and accordingly
     * it will create the object of productData type, which needs to be added in the database.
     *
     * @param product product details in request.
     * @return Product data object, which needs to be updated in DB.
     */
    public ProductData getProductObject(ProductRequestPayload product) {

        switch (product.getProductType()) {
            case ("TV"):
                Product productJson = marshalProductObject(new Television(), product);
                return electronicsMapper.mapTelevision((Television) productJson);
            case ("WASHING_MACHINE"):
                productJson = marshalProductObject(new WashingMachine(), product);
                return electronicsMapper.mapWashingMachine((WashingMachine) productJson);
            default:
                throw new BadRequestDataException("Invalid product type found.");
        }
    }

    /**
     * This method is converting the product details payload json data into Java object, identified by factory method.
     *
     * @param product          instance of Product type.
     * @param productInRequest product details from request.
     * @return Product details as java object.
     */
    private Product marshalProductObject(Product product, ProductRequestPayload productInRequest) {
        Gson gson = new Gson();
        product = gson.fromJson(productInRequest.getPayload(), product.getClass());
        product.setProductType(productInRequest.getProductType());
        Set<ConstraintViolation<Product>> validationErrors = validator.validate(product);
        if (!validationErrors.isEmpty()) {
            throw new BadRequestDataException(new ConstraintViolationException(validationErrors).getMessage());
        }
        return product;
    }

}