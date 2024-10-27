package com.curso.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idSale;

    @ManyToOne
    @JoinColumn(name = "id_client",nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_user",nullable = false)
    private User user;

    @OneToMany(mappedBy = "sale",cascade = CascadeType.ALL)
    private List<SaleDetail> saleDetails;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false,columnDefinition = "decimal(6,2)")
    private double total;

    @Column(nullable = false,columnDefinition = "decimal(6,2)")
    private double tax;

    @Column(nullable = false)
    private boolean enabled;
}
