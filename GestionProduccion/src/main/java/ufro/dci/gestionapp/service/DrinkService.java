package ufro.dci.gestionapp.service;

import org.springframework.stereotype.Service;
import ufro.dci.gestionapp.model.production.Drink;
import ufro.dci.gestionapp.model.shooper.Shooper;
import ufro.dci.gestionapp.repository.DrinkRepository;

@Service
public class DrinkService {
    final DrinkRepository drinkRepository;

    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public void createObjectOfDrink(String drinkFlavor, String drinkSize, Shooper shooper) {
        Drink drink = new Drink(drinkFlavor, drinkSize, shooper);
        saveObjectDrink(drink);
    }

    public void saveObjectDrink(Drink drink) {
        drinkRepository.save(drink);
    }

}
