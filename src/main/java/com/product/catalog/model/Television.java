package com.product.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Television extends Electronics {

    private String screenSize;

   /* @Builder(builderMethodName = "tvBuilder")
    public Television(String serialNumber, String brand, String price, String priceRange, boolean isAvailable, String productCode, int powerConsumptionStar, String screenSize) {
        super(serialNumber, brand, price, priceRange, isAvailable, productCode, powerConsumptionStar);
        this.screenSize = screenSize;
    }*/
}
