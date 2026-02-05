package com.infnet.employeemanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "estado", nullable = false)
    private String state;
    @Column(name = "cidade", nullable = false)
    private String city;
    @Column(name = "rua", nullable = false)
    private String street;
    @Column(name = "cep", nullable = false, length = 8)
    private String zipCode;
}