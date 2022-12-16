package com.ufro.gestionapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Employee extends User{
    @Id
    @Column(length = 4, nullable = false)
    private String pin;

    public Employee() {
    }

}