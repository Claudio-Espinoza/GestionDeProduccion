package com.ufro.gestionapp.model;

//A la hora de usar import, evitar el uso de * por el fin de optimizacion
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
//La etiqueta @Setter y @Getter, genera las funcionalidades sin la necesidad de acumular code Smell
//Con lombok se debe evitar el uso de la etiqueta @Data, puesto que esta conlleva demaciados subprocesos que generar un alto comunsumo de memoria}
// Vease mas (Pagina Oficial): https://projectlombok.org/features/
@Setter
@Getter
public class User {
    //Column: Te permite personalizar las columnas de las tablas referente al atributo bajo la misma (Solo varchar puede modificar su lengh)
    @Column(length = 11, nullable = false)
    private String rut;
    @Column(length = 20)
    private String job;
    @Column(length = 25)
    private String name;
    @Column(length = 25)
    private String lastName;
    @Column(length = 25)
    private String SecondName;
    @Column(length = 25)
    private String typeContract;

    public User() {
    }
}
