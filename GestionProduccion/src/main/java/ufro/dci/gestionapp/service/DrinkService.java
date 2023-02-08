package ufro.dci.gestionapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufro.dci.gestionapp.model.production.Bread;
import ufro.dci.gestionapp.model.production.Drink;
import ufro.dci.gestionapp.model.shooper.Shooper;
import ufro.dci.gestionapp.repository.DrinkRepository;

import java.util.List;

@Service
public class DrinkService {
    final ShooperService shooperService;
    final DrinkRepository drinkRepository;

    public DrinkService(DrinkRepository drinkRepository, ShooperService shooperService) {
        this.drinkRepository = drinkRepository;
        this.shooperService = shooperService;
    }

    public void createObjectOfDrink(String drinkFlavor, String drinkSize, Shooper shooper) {
        Drink drink = new Drink(drinkFlavor, drinkSize, shooper);
        saveObjectDrink(drink);
    }

    public void saveObjectDrink(Drink drink) {
        drinkRepository.save(drink);
    }

    public List<Drink> getListDrink(){
        return drinkRepository.findAllByShooper(shooperService.getShooperByLastId());
    }

}
