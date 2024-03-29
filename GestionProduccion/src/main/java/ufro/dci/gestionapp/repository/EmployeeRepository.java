package ufro.dci.gestionapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ufro.dci.gestionapp.model.employee.Employee;

//@Repository: es una anotación de primavera que indica que la clase decorada es un repositorio.
//Un repositorio es un mecanismo para encapsular el almacenamiento, la recuperación y la búsqueda.
//Comportamiento que emula una colección de objetos.
@Repository                                           //Name Clase/ Tipo de dato de la clave primaria
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    //Dato a retornar / FindBy (Palabra clave) rut (Elemento a identificador) y el parametro (id)
    Employee findByRut(String rut);
}
