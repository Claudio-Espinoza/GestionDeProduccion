package ufro.dci.gestionapp.model.production;

import jakarta.persistence.*;

import ufro.dci.gestionapp.model.shooper.Shooper;

import java.util.List;

@Entity
@Table(name = "pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_pizza", length =10, nullable = false)
    private String name;
    @Column(name = "contador")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contador;
    @ManyToOne
    @JoinColumn(name = "shopper_id")
    private Shooper shooper;
}
