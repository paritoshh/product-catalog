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

/**
 * ProductCatalogController class containing the rest endpoints for all product actions.
 */
@RestController
@Validated
@RequestMapping("/inventory")
public class ProductCatalogController {

    @Autowired
    ProductCatalogService productCatalogService;

    /**
     * This method is adding new product in the catalog
     * @param productDetails Product type and details
     * @return Added product
     */
    @PostMapping(value = "/", produces = {"application/json"})
    public ResponseEntity<ProductData> addProduct(@Valid @RequestBody ProductRequestPayload productDetails) {
        ProductData response = productCatalogService.addProduct(productDetails);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    /**
     * This method is adding multiple products at a same time.
     * Maximum 20 products can we added in a single request.
     * @param products multiple products details.
     * @return List of all added products.
     */
    @PostMapping(value = "/addAll", produces = {"application/json"})
    public ResponseEntity<List<ProductData>> addProducts(@Valid @RequestBody MultipleProductsRequest products) {
        List<ProductData> response = productCatalogService.addAllProducts(products);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    /**
     * Retrieved all products.
     * @return List of products.
     */
    @GetMapping(value = "/", produces = {"application/json"})
    public ResponseEntity<List<ProductData>> fetchAllProducts() {
        List<ProductData> allProducts = productCatalogService.fetchAll();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);

    }

    /**
     * Retrieve product for the provided id.
     * @param id id of the product.
     * @return Product details
     */
    @GetMapping(value = "/id/{id}", produces = {"application/json"})
    public ResponseEntity<ProductData> fetchById(@PathVariable("id") Integer id) {
        ProductData allProducts = productCatalogService.findProductForId(id);
        return new ResponseEntity<>(allProducts, HttpStatus.OK);

    }

    /**
     * Retrieve all products for the provided brand.
     * @param brand brand of the product
     * @return Products details
     */
    @GetMapping(value = "/brand/{brand}", produces = {"application/json"})
    public ResponseEntity<List<ProductData>> fetchByBrand(@PathVariable("brand") String brand) {
        List<ProductData> allProducts = productCatalogService.findProductsForBrand(brand);
        return new ResponseEntity<>(allProducts, HttpStatus.OK);

    }

    /**
     * This method will delete the product for given id.
     * @param id Id od the product which needs to be deleted.
     * @return action completion message
     */
    @PutMapping(value = "delete/{id}", produces = {"application/json"})
    public ResponseEntity<InventoryActionResponse> deleteProduct(@PathVariable("id") Integer id) {
        InventoryActionResponse response = productCatalogService.deleteProduct(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * This method is updating the product for given id.
     * @param id id of the product
     * @param productUpdatedDetails updated details of the product
     * @return Product updated details.
     */
    @PutMapping(value = "update/{id}", produces = {"application/json"})
    public ResponseEntity<ProductData> update(@PathVariable("id") Integer id, @RequestBody ProductRequestPayload productUpdatedDetails) {
        ProductData response = productCatalogService.updateProduct(id, productUpdatedDetails);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}