package ufro.dci.gestionapp.model.employees;

//A la hora de usar import, evitar el uso de * por el fin de optimizacion
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

//"@MappedSuperclass" es semejante a la etiqueta embebible o el uso de los diferentes inserciones de tablas
//la he elegido por su simplicidad
@MappedSuperclass
//La etiqueta @Setter y @Getter, genera las funcionalidades sin la necesidad de acumular code Smell
//Con lombok se debe evitar el uso de la etiqueta @Data, puesto que esta conlleva demaciados subprocesos que generar un alto comunsumo de memoria}
// Vease mas (Pagina Oficial): https://projectlombok.org/features/
@Setter
@Getter
public class User {
    //Column: Te permite personalizar las columnas de las tablas referente al atributo bajo la misma (Solo varchar puede modificar su lengh)
    @Column(name = "rut", length = 11, nullable = false)
    private String rut;
    @Column(name = "job",length = 20, nullable = false)
    private String job;
    @Column(name = "name",length = 25, nullable = false)
    private String name;
    @Column(name = "last_name",length = 25, nullable = false)
    private String lastName;
    @Column(name = "second_name",length = 25, nullable = false)
    private String secondName;
    @Column(name = "type_contract",length = 25, nullable = false)
    private String typeContract;

    public User() {
    }
}