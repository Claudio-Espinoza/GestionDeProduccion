package ufro.dci.gestionapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ufro.dci.gestionapp.model.shooper.Shooper;

@Repository
public interface ShooperRepository extends CrudRepository<Shooper, Integer> {
}
