package com.product.catalog.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
public class WashingMachineData extends ElectronicsData {

    private String capacity;
    private String operation;

    @Builder(builderMethodName = "washingMachineDataBuilder")
    public WashingMachineData(Integer id, String serialNumber, String brand, String price, int powerConsumptionStar, String capacity, String operation) {
        super(id, serialNumber, brand, price, powerConsumptionStar);
        this.capacity = capacity;
        this.operation = operation;
    }
}
