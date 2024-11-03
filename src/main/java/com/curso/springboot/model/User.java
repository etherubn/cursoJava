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
@Table(name = "user_data")
public class User {
    @Id
    @EqualsAndHashCode.Include
    private Long idUser;
    @Column(length = 50,nullable = false,unique = true)
    private String username;
    @Column(length = 60,nullable = false)
    private String password;
    @Column(nullable = false)
    private boolean enabled;

    @ManyToOne
    @JoinColumn(name = "id_role",nullable = false)
    private Role role;
}
