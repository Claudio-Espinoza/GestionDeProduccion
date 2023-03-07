package ufro.dci.gestionapp.service;

import org.springframework.stereotype.Service;
import ufro.dci.gestionapp.model.production.Pizza;
import ufro.dci.gestionapp.model.production.enumerations.Price;
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
        Pizza pizza = new Pizza(name, Price.PRICE_5.getPrice(), shooper);
        saveObjectPizza(pizza);
    }

    private void saveObjectPizza(Pizza pizza){
        pizzaRepository.save(pizza);
    }

    public List<Pizza> getListPizza(Shooper shooper){
        return pizzaRepository.findAllByShooper(shooper);
    }

    public List<Pizza> getAllPizza(){
        return pizzaRepository.findAll();
    }

    private int getLastIdPizza(){
        List<Pizza> lastId=pizzaRepository.findAll();
        return lastId.get(lastId.size()-1).getId();
    }

    public void deleteLastIdPizza(){
        pizzaRepository.deleteById(getLastIdPizza());
    }
    public void deleteByIdPizza(int id){
        pizzaRepository.deleteById(id);
    }

    public int getCostPizzaOfOrder(Shooper shooper) {
        int numPizza = getSizeOfList(getListPizza(shooper));
        return numPizza * Price.PRICE_5.getPrice();
    }
    public int getSizeOfList(List<?> list){
        return list.size();
    }
}
