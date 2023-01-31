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
    @Column(name = "size", length =10, nullable = false)
    private String size;
    @Column(name = "edgy", length =10, nullable = false)
    private String edgy;
    @Column(name = "cheese", length =10, nullable = false)
    private String cheese;
    @Column(name = "contador")
    private int contador;
    @OneToMany(mappedBy="pizza")
    private List<Ingredient> ingredientList;
    @ManyToOne
    @JoinColumn(name = "shopper_id")
    private Shooper shooper;
}
