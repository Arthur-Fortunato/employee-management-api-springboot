package com.infnet.employeemanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String firstName;
    @Column(name = "sobre_nome", nullable = false)
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
}
