package ufro.dci.gestionapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ufro.dci.gestionapp.model.production.Pizza;

@Repository
public interface PizzaRepository  extends CrudRepository<Pizza, Integer> {
}
