package ufro.dci.gestionapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ufro.dci.gestionapp.model.production.Pizza;
import ufro.dci.gestionapp.model.shooper.Shooper;

import java.util.List;

@Repository
public interface PizzaRepository  extends CrudRepository<Pizza, Integer> {
    List<Pizza> findAllByShooper(Shooper shooper);
    List<Pizza> findAll();

    void deleteById(int id);
}
