package ufro.dci.gestionapp.service;

import org.springframework.stereotype.Service;
import ufro.dci.gestionapp.model.shooper.Shooper;

@Service
public class OrderService {
    final PizzaService pizzaService;
    final DrinkService drinkService;
    final BreadService breadService;

    public OrderService(PizzaService pizzaService, DrinkService drinkService, BreadService breadService) {
        this.pizzaService = pizzaService;
        this.drinkService = drinkService;
        this.breadService = breadService;
    }

    public void calculateCost( Shooper shooper){
        int pizzaCost = pizzaService.getCostPizzaOfOrder(shooper);
        int breadCost = breadService.calculateCostBread(shooper);
        int drinkCost = drinkService.calculateCostDrink(shooper);

        System.out.println("Pizza: " + pizzaCost + "Bread: " + breadCost  +"Drink: "+ drinkCost);
    }
}
