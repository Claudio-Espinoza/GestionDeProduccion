package com.ufro.gestionapp.repository;

import com.ufro.gestionapp.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository: es una anotación de primavera que indica que la clase decorada es un repositorio.
//Un repositorio es un mecanismo para encapsular el almacenamiento, la recuperación y la búsqueda.
//comportamiento que emula una colección de objetos.
@Repository                                           //Name Clase/ Tipo de dato de la clave primaria
public interface EmployeeRepository extends CrudRepository<Employee, String> {
                                          //CrudRepository proporciona principalmente funciones CRUD.
                                          //PagingAndSortingRepository proporciona métodos para realizar paginaciones y ordenar registros.
                                          //JpaRepository proporciona algunos métodos relacionados con JPA, como vaciar el contexto de persistencia y eliminar registros en un lote.
}
