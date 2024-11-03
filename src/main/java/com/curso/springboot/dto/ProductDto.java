package com.curso.springboot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

    private Long idProduct;
    @NotNull
    @Min(value = 1)
    private Long idCategory;
    @NotBlank
    private String nameProduct;
    @NotBlank
    private String descriptionProduct;
    @NotNull
    @Positive
    private double priceProduct;
    @NotNull
    private boolean enabledProduct;

}
