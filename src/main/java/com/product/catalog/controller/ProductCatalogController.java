package com.product.catalog.controller;

import com.product.catalog.entity.ProductData;
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
    public ResponseEntity<ProductData> addProduct(@RequestBody ProductRequestPayload productDetails) {
        ProductData response = productCatalogService.addProduct(productDetails);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping(value = "/products", produces = {"application/json"})
    public ResponseEntity<List<Product>> fetchAllProducts(){
        return null;

    }
}

/*
DROP TABLE IF EXISTS tv;

CREATE TABLE tv(
    id INT AUTO_INCREMENT  PRIMARY KEY,
    sno VARCHAR(15) NOT NULL,
    brand VARCHAR(25) NOT NULL,
    price VARCHAR(8) NOT NULL,
    power_star VARCHAR(1) NOT NULL,
    screen_size VARCHAR(2) NOT NULL
);

{
  "productType": "TV",
  "payload": "{\"serialNumber\": \"001\",\"brand\": \"MI\",\"price\": \"23000\",\"priceRange\": \"2-3\",\"powerConsumptionStar\": 1,\"screenSize\": \"41-inch\"}"
}

{
  "productType": "WASHING_MACHINE",
  "payload": "{\"serialNumber\": \"001\",\"brand\": \"MI\",\"price\": \"23000\",\"powerConsumptionStar\": 1,\"capacity\": \"41kg\",\"operation\": \"FrontLoad\"}"
}

 */