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
public class Ingress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idIngress;

    @ManyToOne
    @JoinColumn(name = "id_provider",nullable = false)
    private Provider provider;

    @ManyToOne
    @JoinColumn(name = "id_user",nullable = false)
    private User user;

    @Column(nullable = false,columnDefinition = "decimal(6,2)")
    private double total;
    @Column(nullable = false,columnDefinition = "decimal(6,2)")
    private double tax;
    @Column(nullable = false)
    private boolean enabled;
}
