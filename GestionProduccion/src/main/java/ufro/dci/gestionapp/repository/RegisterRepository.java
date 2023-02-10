package ufro.dci.gestionapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ufro.dci.gestionapp.model.employee.register.UserRegister;

import java.util.List;

@Repository
public interface RegisterRepository extends CrudRepository<UserRegister, Integer> {

    List<UserRegister> findAll();
    UserRegister findByRut(String rut);

    UserRegister findById(int id);

}
