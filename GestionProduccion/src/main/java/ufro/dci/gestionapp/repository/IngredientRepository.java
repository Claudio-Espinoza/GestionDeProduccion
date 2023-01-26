package ufro.dci.gestionapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ufro.dci.gestionapp.model.employee.Employee;

@Repository
public interface IngredientRepository  extends CrudRepository<Employee, Integer> {
}
