package ufro.dci.gestionapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufro.dci.gestionapp.model.production.Pizza;
import ufro.dci.gestionapp.model.shooper.Shooper;
import ufro.dci.gestionapp.repository.PizzaRepository;

@Service
public class PizzaService {
    @Autowired
    PizzaRepository pizzaRepository;

    public void createObject(String name, Shooper shooper){
        Pizza pizza = new Pizza(name, shooper);
        saveObjectPizza(pizza);
    }

    public void saveObjectPizza(Pizza pizza){
        pizzaRepository.save(pizza);
    }

}
