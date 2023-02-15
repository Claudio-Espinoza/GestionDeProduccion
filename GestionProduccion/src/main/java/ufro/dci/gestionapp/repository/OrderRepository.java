package ufro.dci.gestionapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ufro.dci.gestionapp.model.shooper.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
