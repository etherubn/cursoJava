package com.curso.springboot.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleDto {

    private Long idSale;
    @NotNull
    private ClientDto client;
    @NotNull
    private UserDto user;
    @NotNull
    private LocalDateTime dateTime;
    @Positive
    @NotNull
    private double total;
    @Positive
    @NotNull
    private double tax;
    @NotNull
    private boolean enabled;
    @NotNull
    @JsonManagedReference
    private List<SaleDetailDto> details;

}
