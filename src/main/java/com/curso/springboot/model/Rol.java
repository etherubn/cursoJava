package com.curso.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Rol {

    @Id
    @EqualsAndHashCode.Include
    private Long idRol;

    @Column(nullable = false,length = 10)
    private String name;

    @Column(nullable = false)
    private boolean enabled;
}
