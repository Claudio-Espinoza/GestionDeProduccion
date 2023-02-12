package ufro.dci.gestionapp.model.production;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufro.dci.gestionapp.model.shooper.Shooper;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_pizza", length =20, nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private int price;
    @ManyToOne
    @JoinColumn(name = "shopper_id")
    private Shooper shooper;

    public Pizza(String name, int price, Shooper shooper) {
        this.name = name;
        this.price = price;
        this.shooper = shooper;
    }
}
