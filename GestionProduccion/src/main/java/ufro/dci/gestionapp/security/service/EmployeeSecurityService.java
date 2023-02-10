package ufro.dci.gestionapp.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ufro.dci.gestionapp.model.employee.Employee;
import ufro.dci.gestionapp.repository.EmployeeRepository;
import ufro.dci.gestionapp.security.model.EmployeeSecurity;
import ufro.dci.gestionapp.service.ManagerService;

@Service
public class EmployeeSecurityService implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    ManagerService managerService;

    //Esta funcion carga la informacion del reposiotorio para poder ser entregado y validado por la configuracion
    //de segurirdad en el filter Chain usando la funcion respectiva con el mismo nobre y la etiqueta del bean
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByRut(username);
        if (employee == null) {
            throw new UsernameNotFoundException("No Rut");
        }
        managerService.createObject(employee.getRut()); //Crea el objeto que sera posteriormente guardado
        return new EmployeeSecurity(employee);
    }

}
