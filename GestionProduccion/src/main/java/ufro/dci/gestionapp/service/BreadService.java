package ufro.dci.gestionapp.service;

import org.springframework.stereotype.Service;
import ufro.dci.gestionapp.model.production.Bread;
import ufro.dci.gestionapp.model.production.enumerations.BreadEnum;
import ufro.dci.gestionapp.model.production.enumerations.PriceEnum;
import ufro.dci.gestionapp.model.shooper.Shooper;
import ufro.dci.gestionapp.repository.BreadRepository;

import java.util.HashMap;
import java.util.List;

@Service
public class BreadService {
    final BreadRepository breadRepository;

    public BreadService(BreadRepository breadRepository) {
        this.breadRepository = breadRepository;
    }

    private HashMap<String, Integer> createPriceBread(){
        HashMap<String, Integer> breadPrice = new HashMap<>();
        breadPrice.put(BreadEnum.NO.getName(), PriceEnum.PRICE_0.getPrice());
        breadPrice.put(BreadEnum.SALT.getName(), PriceEnum.PRICE_2.getPrice());
        breadPrice.put(BreadEnum.CROISSANT.getName(), PriceEnum.PRICE_3.getPrice());
        breadPrice.put(BreadEnum.WHITE.getName(), PriceEnum.PRICE_4.getPrice());

        return breadPrice;
    }

    private int selectPriceBread(String name){
        HashMap<String, Integer> breadPrice= createPriceBread();
        return breadPrice.get(name);
    }

    public void createObjectOfBread(String name, Shooper shooper) {
        Bread bread = new Bread(name, selectPriceBread(name),  shooper);
        saveObjectBread(bread);
    }

    public void saveObjectBread(Bread bread) {
        breadRepository.save(bread);
    }

    public List<Bread> getListBread(Shooper shooper){
        return breadRepository.findAllByShooper(shooper);
    }

    public int calculateCostBread(Shooper shooper){
        List<Bread> breadList = getListBread(shooper);
        int contPric=0;
        for(Bread bread : breadList){
            contPric = bread.getPrice();
        }
        return contPric;
    }
}
