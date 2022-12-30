package ufro.dci.gestionapp.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ufro.dci.gestionapp.repository.EmployeeRepository;
import ufro.dci.gestionapp.security.model.SecurityEmployee;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    private final EmployeeRepository employeeRepository;

    public JpaUserDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return employeeRepository
                .findByRut(username)
                .map(SecurityEmployee::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found " +  username));
    }
}
