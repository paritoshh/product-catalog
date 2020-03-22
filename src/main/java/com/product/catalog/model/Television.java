package com.product.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Television extends Electronics {

    @NotNull(message = "Screen size is mandatory for Television.")
    @Pattern(regexp = "[0-9a-z' ]{1,10}")
    private String screenSize;
}
