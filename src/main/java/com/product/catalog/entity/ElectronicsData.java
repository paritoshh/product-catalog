package com.product.catalog.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "Electronics")
public class ElectronicsData extends ProductData {

    @Column(name = "POWER_STAR", nullable = false)
    private final int powerConsumptionStar;

    @Builder(builderMethodName = "ElectonicsDataBuilder")
    public ElectronicsData(String serialNumber, String brand, String price, int powerConsumptionStar){
        super(serialNumber, brand, price);
        this.powerConsumptionStar = powerConsumptionStar;
    }
}
