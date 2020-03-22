package com.product.catalog.controller;

import com.product.catalog.entity.ProductData;
import com.product.catalog.model.InventoryActionResponse;
import com.product.catalog.model.MultipleProductsRequest;
import com.product.catalog.model.ProductRequestPayload;
import com.product.catalog.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/inventory")
public class ProductCatalogController {

    @Autowired
    ProductCatalogService productCatalogService;

    @PostMapping(value = "/add", produces = {"application/json"})
    public ResponseEntity<ProductData> addProduct(@Valid @RequestBody ProductRequestPayload productDetails) {
        ProductData response = productCatalogService.addProduct(productDetails);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping(value = "/addAll", produces = {"application/json"})
    public ResponseEntity<List<ProductData>> addProduct(@RequestBody MultipleProductsRequest products) {
        List<ProductData> response = productCatalogService.addAllProducts(products);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = {"application/json"})
    public ResponseEntity<List<ProductData>> fetchAllProducts(){
        List<ProductData> allProducts = productCatalogService.fetchAll();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);

    }

    @GetMapping(value = "/id/{id}", produces = {"application/json"})
    public ResponseEntity<ProductData> fetchById(@PathVariable("id") Integer id){
        ProductData allProducts = productCatalogService.findProductForId(id);
        return new ResponseEntity<>(allProducts, HttpStatus.OK);

    }

    @GetMapping(value = "/brand/{brand}", produces = {"application/json"})
    public ResponseEntity<List<ProductData>> fetchByBrand(@PathVariable("brand") String brand){
        List<ProductData> allProducts = productCatalogService.findProductsForBrand(brand);
        return new ResponseEntity<>(allProducts, HttpStatus.OK);

    }

    @PutMapping(value = "delete/{id}", produces = {"application/json"})
    public ResponseEntity<InventoryActionResponse> deleteProduct(@PathVariable("id") Integer id){
        InventoryActionResponse response = productCatalogService.deleteProduct(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(value = "update/{id}", produces = {"application/json"})
    public ResponseEntity<ProductData> update(@PathVariable("id") Integer id, @RequestBody ProductRequestPayload productUpdatedDetails){
        ProductData response = productCatalogService.updateProduct(id, productUpdatedDetails);
        return new ResponseEntity<>(response, HttpStatus.OK);
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
  "payload": "{\"serialNumber\": \"001\",\"brand\": \"BPL\",\"price\": \"23000\",\"priceRange\": \"2-3\",\"powerConsumptionStar\": 1,\"screenSize\": \"41-inch\",\"description\": \"This is a new android TV\"}"
}
{
  "productType": "WASHING_MACHINE",
  "payload": "{\"serialNumber\": \"001\",\"brand\": \"MI\",\"price\": \"23000\",\"powerConsumptionStar\": 1,\"capacity\": \"41kg\",\"operation\": \"FrontLoad\",\"description\": \"This is a automatic machine.\"}"
}


Add multiple:
{
  "products": [
    {
      "productType": "TV",
      "payload": "{\"serialNumber\": \"001\",\"brand\": \"MI\",\"price\": \"23000\",\"priceRange\": \"2-3\",\"powerConsumptionStar\": 1,\"screenSize\": \"41-inch\",\"description\": \"This is a new andriod TV\"}"
    },
    {
      "productType": "WASHING_MACHINE",
      "payload": "{\"serialNumber\": \"001\",\"brand\": \"MI\",\"price\": \"23000\",\"powerConsumptionStar\": 1,\"capacity\": \"41kg\",\"operation\": \"FrontLoad\",\"description\": \"This is a automatic machine.\"}"
    }
  ]
}

 */