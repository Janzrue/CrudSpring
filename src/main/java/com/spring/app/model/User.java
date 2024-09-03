package com.spring.app.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(name="Name")
    private String name;

    @NotBlank
    @Column(name="LastName")
    private String lastName;

    @NotBlank
    @NegativeOrZero
    @Column(name="Age")
    private int age;
}
