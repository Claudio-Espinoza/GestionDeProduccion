package ufro.dci.gestionapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ufro.dci.gestionapp.model.production.Drink;
import ufro.dci.gestionapp.model.shooper.Shooper;

import java.util.List;

@Repository
public interface DrinkRepository extends CrudRepository<Drink, Integer> {
    List<Drink> findAllByShooper(Shooper shooper);
}
