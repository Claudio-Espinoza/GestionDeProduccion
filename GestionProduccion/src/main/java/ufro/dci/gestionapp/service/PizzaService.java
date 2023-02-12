package ufro.dci.gestionapp.service;

import org.springframework.stereotype.Service;
import ufro.dci.gestionapp.model.production.Pizza;
import ufro.dci.gestionapp.model.production.enumerations.PriceEnum;
import ufro.dci.gestionapp.model.shooper.Shooper;
import ufro.dci.gestionapp.repository.PizzaRepository;

import java.util.List;

@Service
public class PizzaService {
    final
    PizzaRepository pizzaRepository;
    final
    ShooperService shooperService;

    public PizzaService(PizzaRepository pizzaRepository, ShooperService shooperService) {
        this.pizzaRepository = pizzaRepository;
        this.shooperService = shooperService;
    }

    public void createObject(String name, Shooper shooper){
        Pizza pizza = new Pizza(name, PriceEnum.PRICE_5.getPrice(), shooper);
        saveObjectPizza(pizza);
    }

    public void saveObjectPizza(Pizza pizza){
        pizzaRepository.save(pizza);
    }

    public List<Pizza> getListPizza(){
        return pizzaRepository.findAllByShooper(shooperService.getShooperByLastId());
    }

    public List<Pizza> getAllPizza(){
        return pizzaRepository.findAll();
    }

    private int getLastIdPizza(){
        List<Pizza> lastId=pizzaRepository.findAll();
        return lastId.get(lastId.size()-1).getId();
    }

    public void deleteByIdPizza(){
        pizzaRepository.deleteById(getLastIdPizza());
    }

}
