package com.ufro.gestionapp.model;

import jakarta.persistence.*;
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
