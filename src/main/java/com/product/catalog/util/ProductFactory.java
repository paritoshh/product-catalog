package com.product.catalog.util;

import com.google.gson.Gson;
import com.product.catalog.entity.ProductData;
import com.product.catalog.exception.BadRequestDataException;
import com.product.catalog.mapper.ElectronicsMapper;
import com.product.catalog.model.Product;
import com.product.catalog.model.ProductRequestPayload;
import com.product.catalog.model.Television;
import com.product.catalog.model.WashingMachine;
import com.product.catalog.repository.WashingMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

@Service
public class ProductFactory {
    @Autowired
    WashingMachineRepository washingMachineRepository;
    @Autowired
    ElectronicsMapper electronicsMapper;
    @Autowired
    private Validator validator;

    public ProductData getProductObject(ProductRequestPayload product) {

        switch (product.getProductType()) {
            case ("TV"):
                Product productJson = marshalProductObject(new Television(), product);
                return electronicsMapper.mapTelevision((Television) productJson);
            case ("WASHING_MACHINE"):
                productJson = marshalProductObject(new WashingMachine(), product);
                return electronicsMapper.mapWashingMachine((WashingMachine) productJson);
        }
        return null;
    }

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
