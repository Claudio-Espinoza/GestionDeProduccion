package ufro.dci.gestionapp.model.employees;

//A la hora de usar import, evitar el uso de * por el fin de optimización
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Con la etiqueta @Entity tiene la funcionalidad de señalar una clase para ser identificada por EntityManager y poder ser manejado por JPA
//En otras palabras, convierte la clase en una tabla de base de datos y genera las columnas con los atributos de la clase
@Entity
//La etiqueta @Setter y @Getter, genera las funcionalidades sin la necesidad de acumular code Smell
//La etiqueta @AllArgsConstructor, genera un constructor con todos los parámetros y @NoArgsConstructor uno vació
//Con lombok se debe evitar el uso de la etiqueta @Data, puesto que esta conlleva demasiados subprocesos que generar un alto consumo de memoria
// Ver más (Pagina Oficial): https://projectlombok.org/features/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee extends User {

    //Con la etiqueta @Entity tiene la funcionalidad de señalar una clase para ser identificada por EntityManager y poder ser manejado por JPA
    @Id
    //Column: Te permite personalizar las columnas de las tablas referentes al atributo bajo la misma (Solo varchar puede modificar su length)
    @Column(name = "pin", nullable = false)
    private String pin;

    public Employee(String rut, String job, String rol, String name, String lastName, String secondName, String typeContract, String pin) {
        super(rut, job, rol, name, lastName, secondName, typeContract);
        this.pin = pin;
    }


    //El constructor es sumamente necesario para poder proveer de interacciones con el programa
    //No es necesario usar constructor con parámetros
}