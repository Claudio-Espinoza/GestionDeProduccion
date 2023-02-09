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
@Table(name = "bread")
public class Bread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_bread", length =20, nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "shopper_id")
    private Shooper shooper;

    public Bread(String name, Shooper shooper) {
        this.name = name;
        this.shooper = shooper;
    }
}
