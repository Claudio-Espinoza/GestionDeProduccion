package com.ufro.gestionapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Admin extends User{

    @Id
    @Column(length = 15, nullable = false)
    private String SerialAdminPin;

    public Admin() {
    }
}
