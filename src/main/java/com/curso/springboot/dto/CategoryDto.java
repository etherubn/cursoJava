package com.curso.springboot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {
    private Long idCategory;
    @NotBlank
    @Size(min = 3,max = 20)
    private String nameofCategory;
    @NotBlank
    @Size(min = 3,max = 20)
    private String descriptionCategory;
    @NotNull
    private boolean enabledCategory;
}
