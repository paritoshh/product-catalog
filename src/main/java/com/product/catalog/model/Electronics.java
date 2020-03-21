package com.product.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Electronics extends Product {

    private int powerConsumptionStar;

   /* @Builder(builderMethodName = "ElectonicsBuilder")
    public Electronics(String serialNumber, String brand, String price, String priceRange, Boolean isAvailable, String productCode, int powerConsumptionStar){
        super(serialNumber, brand, price, priceRange, isAvailable, productCode);
        this.powerConsumptionStar = powerConsumptionStar;
    }*/

}
