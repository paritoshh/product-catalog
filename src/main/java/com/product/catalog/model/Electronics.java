package com.product.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Electronics extends Product {

    @NotNull
    @Min(value = 1, message = "Minimum power star is 1")
    @Max(value = 5, message = "Maximum power star is 5")
    private int powerConsumptionStar;
}
