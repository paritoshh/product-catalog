package com.product.catalog.model;

import lombok.Getter;

@Getter
public class WashingMachine extends Electronics {

    private String capacity;
    private String operation;

    /*@Builder(builderMethodName = "washingMachineDataBuilder")
    public WashingMachine(String serialNumber, String brand, String price, String priceRange, boolean isAvailable, String productCode, int powerConsumptionStar, String capacity, String operation) {
        super(serialNumber, brand, price, priceRange, isAvailable, productCode, powerConsumptionStar);
        this.capacity = capacity;
        this.operation = operation;
    }*/
}
