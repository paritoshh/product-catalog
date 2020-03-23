package com.product.catalog.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9-_/]{1,10}")
    private String serialNumber;
    @NotNull
    @Pattern(regexp = "[a-zA-Z ]{1,20}")
    private String brand;
    @NotNull
    @Pattern(regexp = "[0-9.]{1,10}")
    private String price;
    @NotNull
    @Pattern(regexp = "[a-zA-Z-_ ]{1,15}")
    private String productType;
    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9- @$%+';()#_:/.]{1,100}")
    private String description;
}