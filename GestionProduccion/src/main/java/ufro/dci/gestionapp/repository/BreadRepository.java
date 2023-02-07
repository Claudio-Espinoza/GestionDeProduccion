package ufro.dci.gestionapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ufro.dci.gestionapp.model.production.Bread;

@Repository
public interface BreadRepository extends CrudRepository<Bread, Integer> {
}
