package com.product.catalog.service;

import com.product.catalog.entity.ProductData;
import com.product.catalog.exception.BadRequestDataException;
import com.product.catalog.exception.handler.NoDataFoundException;
import com.product.catalog.mapper.ElectronicsMapper;
import com.product.catalog.model.InventoryActionResponse;
import com.product.catalog.model.MultipleProductsRequest;
import com.product.catalog.model.ProductRequestPayload;
import com.product.catalog.repository.ProductRepository;
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

    private static final String NO_RECORD_FOUND = "No record found for";
    private static final String PRODUCT_ID_MESSAGE = "product id:";


    /**
     * This method is adding new product.
     *
     * @param product details
     * @return added project
     */
    @Override
    public ProductData addProduct(ProductRequestPayload product) {
        ProductData productDetailsInRequest = productFactory.getProductObject(product);
        return repository.save(productDetailsInRequest);
    }

    /**
     * This method is adding multiple products.
     *
     * @param products details
     * @return added project
     */
    @Override
    public List<ProductData> addAllProducts(MultipleProductsRequest products) {
        List<ProductData> productsData = new ArrayList<>();
        products.getProducts().forEach(product -> productsData.add(productFactory.getProductObject(product)));
        return repository.saveAll(productsData);
    }

    /**
     * This method is fetching all products.
     *
     * @return products
     */
    @Override
    public List<ProductData> fetchAll() {
        return repository.findAll();
    }

    /**
     * Fetch the product for the given id
     *
     * @param id of product
     * @return product details
     */
    @Override
    public ProductData findProductForId(Integer id) {
        if (!repository.findById(id).isPresent()) {
            throw new NoDataFoundException(
                    new StringBuilder(NO_RECORD_FOUND).append(PRODUCT_ID_MESSAGE).append(id).toString());
        }
        return repository.findById(id).get();
    }

    /**
     * This method is fetching all products for the given brand.
     *
     * @param brand brand in request
     * @return products details of the given brand
     */
    @Override
    public List<ProductData> findProductsForBrand(String brand) {

        if (repository.findByBrand(brand).isEmpty()) {
            throw new NoDataFoundException(
                    new StringBuilder(NO_RECORD_FOUND).append(" brand:").append(brand).toString());
        }
        return repository.findByBrand(brand);
    }

    /**
     * This method is fetching all products.
     *
     * @return products
     */
    @Override
    public InventoryActionResponse deleteProduct(Integer id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return InventoryActionResponse.builder()
                    .code("ERR-101")
                    .message(new StringBuilder(NO_RECORD_FOUND).append(PRODUCT_ID_MESSAGE).append(id.toString()).toString())
                    .build();
        }
        return InventoryActionResponse.builder()
                .code("SUC-101")
                .message("Product deleted successfully.")
                .build();
    }

    /**
     * This method is updating product.
     *
     * @param id which needs to be updated
     * @param updatedProduct updated details
     * @return updated product
     */
    @Override
    public ProductData updateProduct(Integer id, ProductRequestPayload updatedProduct) {
        Optional<ProductData> existingDetails = repository.findById(id);
        if (!existingDetails.isPresent()) {
            throw new NoDataFoundException(
                    new StringBuilder(NO_RECORD_FOUND).append(PRODUCT_ID_MESSAGE).append(id).toString());
        }
        ProductData productDetailsInRequest = productFactory.getProductObject(updatedProduct);
        productDetailsInRequest.setId(id);
        return repository.save(productDetailsInRequest);

    }
}