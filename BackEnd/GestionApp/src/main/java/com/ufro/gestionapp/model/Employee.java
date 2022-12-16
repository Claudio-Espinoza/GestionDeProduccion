package com.ufro.gestionapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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