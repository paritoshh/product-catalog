package com.product.catalog.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table(name="TV")
@NoArgsConstructor
public class TelevisionData extends ElectronicsData {

    @Column(name = "SCREEN_SIZE")
    private String screenSize;

    @Builder(builderMethodName = "tvDataBuilder")
    public TelevisionData(Integer id, String serialNumber, String brand, String price, int powerConsumptionStar, String screenSize) {
        super(id, serialNumber, brand, price, powerConsumptionStar);
        this.screenSize = screenSize;
    }
}
