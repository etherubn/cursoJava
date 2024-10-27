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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idProduct;

    @Column(nullable = false,length = 50)
    private String name;
    @Column(nullable = false,length = 50)
    private String description;
    @Column(nullable = false,columnDefinition = "decimal(6,2)")
    private double price;
    @Column(nullable = false)
    private Integer stock;
    @Column(nullable = false)
    private boolean enabled;

    @JoinColumn(name = "id_category",nullable = false)
    @ManyToOne
    private Category category;

}
