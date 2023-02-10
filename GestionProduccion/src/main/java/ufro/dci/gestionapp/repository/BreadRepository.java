package ufro.dci.gestionapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ufro.dci.gestionapp.model.production.Bread;
import ufro.dci.gestionapp.model.shooper.Shooper;

import java.util.List;

@Repository
public interface BreadRepository extends CrudRepository<Bread, Integer> {
    List<Bread> findAllByShooper(Shooper shooper);

}
