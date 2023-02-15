package ufro.dci.gestionapp.service;

import org.springframework.stereotype.Service;
import ufro.dci.gestionapp.model.production.Drink;
import ufro.dci.gestionapp.model.production.enumerations.DrinkEnum;
import ufro.dci.gestionapp.model.production.enumerations.PriceEnum;
import ufro.dci.gestionapp.model.shooper.Shooper;
import ufro.dci.gestionapp.repository.DrinkRepository;

import java.util.HashMap;
import java.util.List;


@Service
public class DrinkService {
    final DrinkRepository drinkRepository;

    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    private HashMap<String, Integer> createPriceDrink(){
        HashMap<String, Integer> drinkPrice = new HashMap<>();
        drinkPrice.put(DrinkEnum.SMALL.getSize(), PriceEnum.PRICE_1.getPrice());
        drinkPrice.put(DrinkEnum.MEDIUM.getSize(), PriceEnum.PRICE_2.getPrice());
        drinkPrice.put(DrinkEnum.LARGE.getSize(), PriceEnum.PRICE_3.getPrice());

        return drinkPrice;
    }

    private int selectPriceDrink(String size){
        HashMap<String, Integer> drinkPrice= createPriceDrink();
        return drinkPrice.get(size);
    }

    public void createObjectOfDrink(String drinkFlavor, String drinkSize, Shooper shooper) {
        Drink drink = new Drink(drinkFlavor, selectPriceDrink(drinkSize) ,drinkSize, shooper);
        saveObjectDrink(drink);
    }

    public void saveObjectDrink(Drink drink) {
        drinkRepository.save(drink);
    }

    public List<Drink> getListDrink(Shooper shooper){
        return drinkRepository.findAllByShooper(shooper);
    }

    public List<Drink> getAllDrink(){
        return drinkRepository.findAll();
    }

    public int calculateCostDrink(Shooper shooper){
        List<Drink> drinkList = getListDrink(shooper);
        int contPric=0;
        for(Drink drink : drinkList){
            contPric = drink.getPrice();
        }
        return contPric;
    }
}
