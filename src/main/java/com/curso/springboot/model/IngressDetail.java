package com.curso.springboot.model;

import com.curso.springboot.model.key.IngressDetailKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(IngressDetailKey.class)
public class IngressDetail {

    @Id
    private Product product;

    @Id
    private Ingress ingress;

    private int quantity;

    @Column(nullable = false,columnDefinition = "decimal(6,2)")
    private int cost;

}
