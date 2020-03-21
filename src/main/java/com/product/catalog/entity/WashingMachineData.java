package com.product.catalog.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;

@Getter
@Entity
public class WashingMachineData extends ElectronicsData {

    private String capacity;
    private String operation;

    @Builder(builderMethodName = "washingMachineDataBuilder")
    public WashingMachineData(String serialNumber, String brand, String price, int powerConsumptionStar, String capacity, String operation) {
        super(serialNumber, brand, price, powerConsumptionStar);
        this.capacity = capacity;
        this.operation = operation;
    }
}
