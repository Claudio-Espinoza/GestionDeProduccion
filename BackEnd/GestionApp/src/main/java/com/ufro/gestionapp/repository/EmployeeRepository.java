package com.ufro.gestionapp.repository;

import com.ufro.gestionapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<User, String> {
}
