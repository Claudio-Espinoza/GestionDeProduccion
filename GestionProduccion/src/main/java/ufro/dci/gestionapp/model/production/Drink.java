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
@Table(name = "drink")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "drink_flavor", length = 20, nullable = false)
    private String drinkFlavor;
    @Column(name = "price", nullable = false)
    private int price;
    @Column(name = "size_drink", length =20, nullable = false)
    private String drinkSize;
    @ManyToOne
    @JoinColumn(name = "shopper_id")
    private Shooper shooper;

    public Drink(String drinkFlavor, int price, String drinkSize, Shooper shooper) {
        this.drinkFlavor = drinkFlavor;
        this.price = price;
        this.drinkSize = drinkSize;
        this.shooper = shooper;
    }
}
