package com.product.catalog.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "Electronics")
public class ElectronicsData extends ProductData {

    @Column(name = "POWER_STAR", nullable = false)
    private int powerConsumptionStar;

    @Builder(builderMethodName = "ElectonicsDataBuilder")
    public ElectronicsData(Integer id, String serialNumber, String brand, String price, int powerConsumptionStar, String description, String productType) {
        super(id, serialNumber, brand, price, description, productType);
        this.powerConsumptionStar = powerConsumptionStar;
    }
}
