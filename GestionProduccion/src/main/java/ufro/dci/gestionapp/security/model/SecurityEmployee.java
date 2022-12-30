package ufro.dci.gestionapp.security.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ufro.dci.gestionapp.model.employees.Employee;

import java.util.Arrays;
import java.util.Collection;

@Setter
@Getter
public class SecurityEmployee implements UserDetails {
    private Employee employee;
    public SecurityEmployee(Employee employee) {
        this.employee = employee;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(employee
                        .getRol()
                        .split(","))
                .map(SimpleGrantedAuthority::new)
                .toList();
    }
    @Override
    public String getPassword() {
        return employee.getPin();
    }
    @Override
    public String getUsername() {
        return employee.getRut();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
