package com.curso.springboot.model.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IngressDetailKey implements Serializable {
    @Column(name = "id_product")
    private Long idProduct;
    @Column(name = "id_ingress")
    private Long idIngress;



}
