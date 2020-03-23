package com.product.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Electronics extends Product {

    @NotNull
    @Min(value = 1, message = "Minimum power star is 1")
    @Max(value = 5, message = "Maximum power star is 5")
    private int powerConsumptionStar;
}
