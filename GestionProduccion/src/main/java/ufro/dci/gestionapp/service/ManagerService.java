package ufro.dci.gestionapp.service;

import org.springframework.stereotype.Service;
import ufro.dci.gestionapp.repository.EmployeeRepository;

@Service
public class ManagerService {

    final EmployeeRepository employeeRepository;

    public ManagerService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String getEmployeeName(){
        int idEmployee = 3;
        return employeeRepository.findById(idEmployee).get().getName();
    }

    public String getEmployeeLastName() {
        int idEmployee = 3;
        return employeeRepository.findById(idEmployee).get().getLastName();
    }
}
