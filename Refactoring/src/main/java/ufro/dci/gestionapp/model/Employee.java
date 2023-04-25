package ufro.dci.gestionapp.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "employee")
public class Employee extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "type_contract", length = 25, nullable = false)
    private String typeContract;
    @Column(name = "password", nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    //Se usara para insertar datos en la base de datos
    public Employee(String rut, String name, String lastName, String secondName, String typeContract, String password, Role role) {
        super(rut, name, lastName, secondName);
        this.typeContract = typeContract;
        this.password = password;
        this.role = role;
    }
}
