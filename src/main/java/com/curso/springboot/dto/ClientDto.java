package com.curso.springboot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto {
    private Long idClient;
    @NotBlank
    @Size(min = 3,max = 20)
    private String firstName;
    @NotBlank
    @Size(min = 3,max = 20)
    private String lastName;
    @NotBlank
    @Size(min = 3,max = 20)
    private String country;
    @NotBlank
    @Size(min = 10,max = 10)
    private String cardId;
    @NotBlank
    @Pattern(regexp = "[0-9]+")
    private String phoneNumber;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 3,max = 150)
    private String address;
}
