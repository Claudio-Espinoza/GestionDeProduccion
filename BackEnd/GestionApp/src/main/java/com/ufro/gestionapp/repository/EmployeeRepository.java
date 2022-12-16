package com.ufro.gestionapp.repository;

import com.ufro.gestionapp.model.Employee;
import com.ufro.gestionapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {
}
