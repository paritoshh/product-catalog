package com.product.catalog.util;

import com.google.gson.Gson;
import com.product.catalog.model.Product;
import com.product.catalog.model.ProductRequestPayload;
import com.product.catalog.model.Television;
import com.product.catalog.model.WashingMachine;
import com.product.catalog.repository.TvRepository;
import com.product.catalog.repository.WashingMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductFactory {
    @Autowired
    TvRepository tvRepository;
    @Autowired
    WashingMachineRepository washingMachineRepository;

    public Product getProductObject(ProductRequestPayload product){

        switch (product.getProductType()){
            case ("TV"):
                return marshalProductObject(new Television(), product.getPayload(), tvRepository);
            case ("WASHING_MACHINE"):
                return marshalProductObject(new WashingMachine(), product.getPayload(), washingMachineRepository);
        }
        return null;
    }
    private Product marshalProductObject(Product product, String jsonInput, JpaRepository jpaRepository){
        System.out.println("Class name2::"+product.getClass());
        Gson gson = new Gson();
        product = gson.fromJson(jsonInput, product.getClass());
        product.setJpaRepository(jpaRepository);
        System.out.println(product);

        return product;
    }

}
