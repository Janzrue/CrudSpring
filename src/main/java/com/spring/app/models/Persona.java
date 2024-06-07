package com.spring.app.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Column(name="name")
    @Getter
    @Setter
    private String nombre;

    @Column(name="phone")
    @Getter
    @Setter
    private String telefono;
}
