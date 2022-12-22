package ufro.dci.gestionapp.model.employees;

//A la hora de usar import, evitar el uso de * por el fin de optimizacion
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//Con la etiqueta @Entity tiene la funcionalidad de señalar una clase para ser idenficada por EntityManager y poder ser manejado por JPA
//En otras palabras convierte la clase en un tabla de la base de datos y genera las columnas con los atributos de la clase
@Entity
//La etiqueta @Setter y @Getter, genera las funcionalidades sin la necesidad de acumular code Smell
//Con lombok se debe evitar el uso de la etiqueta @Data, puesto que esta conlleva demaciados subprocesos que generar un alto comunsumo de memoria}
// Vease mas (Pagina Oficial): https://projectlombok.org/features/
@Setter
@Getter
@Table(name = "employee")
public class Employee extends User {

    //Con la etiqueta @Entity tiene la funcionalidad de señalar una clase para ser idenficada por EntityManager y poder ser manejado por JPA
    @Id
    //Column: Te permite personalizar las columnas de las tablas referente al atributo bajo la misma (Solo varchar puede modificar su lengh)
    @Column(name = "pin", length = 4, nullable = false)
    private String pin;

    //El constructor es sumamente necesario para poder preveer de interaccion con el programa
    //No es necesario usar constructor con parametros
    public Employee() {
    }

}