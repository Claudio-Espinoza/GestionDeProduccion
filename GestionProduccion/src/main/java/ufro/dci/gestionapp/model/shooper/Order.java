package ufro.dci.gestionapp.model.shooper;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_shooper", length = 100, nullable = false)
    private String nameShooper;
    @Column(name = "paid", nullable = false)
    private int paid;
    @Column(name = "type_paid", length = 15, nullable = false)
    private String typePaid;
    @Column(name = "date", nullable = false)
    private LocalDateTime date;
    @Column(name = "num_pizza")
    private int numPizza;
    @Column(name = "num_drink")
    private int numDrink;
    @Column(name = "num_bread")
    private int numBread;

    public Order(String nameShooper, int paid, String typePaid, LocalDateTime date, int numPizza, int numDrink, int numBread) {
        this.nameShooper = nameShooper;
        this.paid = paid;
        this.typePaid = typePaid;
        this.date = date;
        this.numPizza = numPizza;
        this.numDrink = numDrink;
        this.numBread = numBread;
    }
}
