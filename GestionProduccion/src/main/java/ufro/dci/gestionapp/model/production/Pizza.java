package ufro.dci.gestionapp.model.production;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import ufro.dci.gestionapp.model.shooper.Shooper;

import java.util.List;

@Entity
@Table(name = "pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy="pizza")
    private List<Ingredient> ingredientList;
    @ManyToOne
    @JoinColumn(name = "shopper_id")
    private Shooper shooper;
}
