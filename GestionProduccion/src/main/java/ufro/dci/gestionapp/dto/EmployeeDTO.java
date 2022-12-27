package ufro.dci.gestionapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

    private String pin;
    private String rut;
    private String job;
    private String name;
    private String lastName;
    private String secondName;
    private String typeContract;

    public EmployeeDTO(String pin, String rut, String job, String name, String lastName, String secondName, String typeContract) {
        this.pin = pin;
        this.rut = rut;
        this.job = job;
        this.name = name;
        this.lastName = lastName;
        this.secondName = secondName;
        this.typeContract = typeContract;
    }

    public EmployeeDTO(String pin) {
        this.pin = pin;
    }

    public EmployeeDTO() {
    }
}

