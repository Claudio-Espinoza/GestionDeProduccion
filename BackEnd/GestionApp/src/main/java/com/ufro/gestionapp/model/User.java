package com.ufro.gestionapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Setter
@Getter
public class User {
    @Column(length = 11, nullable = false)
    private String rut;

    private String job;
    private String name;
    private String lastName;
    private String SecondName;
    private String typeContract;

    public User() {
    }
}
