package ufro.dci.gestionapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ufro.dci.gestionapp.model.shooper.Shooper;

import java.util.List;

@Repository
public interface ShooperRepository extends CrudRepository<Shooper, Integer> {
    List<Shooper> findAll();
    Shooper findById(int id);
}
