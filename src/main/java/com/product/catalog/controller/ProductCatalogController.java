package com.product.catalog.controller;

import com.product.catalog.model.InventoryResponse;
import com.product.catalog.model.Product;
import com.product.catalog.model.ProductRequestPayload;
import com.product.catalog.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class ProductCatalogController {

    @Autowired
    ProductCatalogService productCatalogService;

    @PostMapping(value = "/add", produces = {"application/json"})
    public ResponseEntity<InventoryResponse> addProduct(@RequestBody ProductRequestPayload productDetails) {
        InventoryResponse response = productCatalogService.addProduct(productDetails);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/products", produces = {"application/json"})
    public ResponseEntity<List<Product>> fetchAllProducts(){
        return null;

    }
}