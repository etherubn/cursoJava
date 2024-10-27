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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idclient;

    @Column(length = 25, name = "first_name",nullable = false)
    private String firstName;
    @Column(length = 25,name = "last_name",nullable = false)
    private String lastName;
    @Column(length = 10,name = "card_id",nullable = false,unique = true)
    private String cardId;
    @Column(length = 10, name = "phone_number",nullable = false)
    private String phoneNumber;
    @Column(length = 50,nullable = false)
    private String email;
    @Column(length = 150,nullable = false)
    private String address;
    @Column(length = 35,nullable = false)
    private String country;

}
