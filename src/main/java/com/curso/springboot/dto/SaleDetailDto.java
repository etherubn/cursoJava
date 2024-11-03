package com.curso.springboot.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleDetailDto {
    //@NotNull: Para ingresar un sale, no debo estar obligado a colocarlo
    @JsonBackReference
    private SaleDto sale;
    @NotNull
    private ProductDto product;
    @NotNull
    @Positive
    private int quantity;
    @NotNull
    @Positive
    private double salePrice;
    @NotNull
    @PositiveOrZero
    private double discount;
}
