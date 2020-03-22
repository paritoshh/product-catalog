package com.product.catalog.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table(name="TV")
public class TelevisionData extends ElectronicsData {

    @Column(name = "SCREEN_SIZE")
    private String screenSize;

    @Builder(builderMethodName = "tvDataBuilder")
    public TelevisionData(String serialNumber, String brand, String price, int powerConsumptionStar, String screenSize) {
        super(serialNumber, brand, price, powerConsumptionStar);
        this.screenSize = screenSize;
    }
}
