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
public class UserDto {
    private Long idUser;
    @NotNull
    private RoleDto role;

    @NotBlank
    @Size(min = 1,max = 30)
    private String username;
    @Size(min = 1,max = 60)
    @NotBlank
    private String password;
    @NotNull
    private boolean enabled;
}
