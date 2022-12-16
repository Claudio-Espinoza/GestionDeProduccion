package com.ufro.gestionapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Setter
@Getter
public class User {
    @Column(length = 11, nullable = false)
    private String rut;
    @Column(length = 20)
    private String job;
    @Column(length = 25)
    private String name;
    @Column(length = 25)
    private String lastName;
    @Column(length = 25)
    private String SecondName;
    @Column(length = 25)
    private String typeContract;

    public User() {
    }
}
