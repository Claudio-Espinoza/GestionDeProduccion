package ufro.dci.gestionapp.model.shooper;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufro.dci.gestionapp.model.production.Pizza;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shooper")
public class Shooper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", length = 25, nullable = false)
    private String name;
    @Column(name = "phone", length = 25, nullable = false)
    private String phone;
    @Column(name = "means_delivery", length = 25, nullable = false)
    private String meansDelivery;
    @Column(name = "commentary", length = 25, nullable = false)
    private String commentary;

    @OneToMany(mappedBy="shooper")
    private List<Pizza> pizzaList;

}
