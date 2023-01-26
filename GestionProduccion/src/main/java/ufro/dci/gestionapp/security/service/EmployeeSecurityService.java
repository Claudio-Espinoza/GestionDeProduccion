package ufro.dci.gestionapp.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ufro.dci.gestionapp.model.employee.Employee;
import ufro.dci.gestionapp.repository.EmployeeRepository;
import ufro.dci.gestionapp.security.model.EmployeeSecurity;

@Service
public class EmployeeSecurityService implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByRut(username);
        if (employee == null) {
            throw new UsernameNotFoundException("No user found with the given email");
        }
        return new EmployeeSecurity(employee);
    }

}
