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
public class SaleDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idSaleDetail;

    @ManyToOne
    @JoinColumn(name = "id_sale",nullable = false)
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "id_product",nullable = false)
    private Product product;


    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false,columnDefinition = "decimal(6,2)")
    private double salePrice;

    @Column(nullable = false,columnDefinition = "decimal(6,2)")
    private double discount;
}
