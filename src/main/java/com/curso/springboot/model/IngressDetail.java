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
public class IngressDetail {

    @EmbeddedId
    private IngressDetailKey idIngressDetail;

    @ManyToOne
    @JoinColumn(name = "id_product")
    @MapsId("idProduct")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_ingress")
    @MapsId("idIngress")
    private Ingress ingress;

    private int quantity;

    @Column(nullable = false,columnDefinition = "decimal(6,2)")
    private int cost;

}
