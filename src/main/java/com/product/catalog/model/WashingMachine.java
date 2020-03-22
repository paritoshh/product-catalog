package com.product.catalog.model;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
public class WashingMachine extends Electronics {

    @NotNull(message = "Capacity is mandatory for Television.")
    @Pattern(regexp = "[0-9a-zA-Z ]{1,6}")
    private String capacity;
    @NotNull(message = "Operation is mandatory for Television.")
    @Pattern(regexp = "[a-zA-Z ]{1,15}")
    private String operation;
}
