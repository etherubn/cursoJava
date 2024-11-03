package com.curso.springboot.model.key;

import com.curso.springboot.model.Ingress;
import com.curso.springboot.model.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;


import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class IngressDetailKey implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_ingrees",nullable = false)
    private Ingress ingress;

    @ManyToOne
    @JoinColumn(name = "id_product",nullable = false)
    private Product product;
}
