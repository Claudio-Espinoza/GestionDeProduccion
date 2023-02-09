package ufro.dci.gestionapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufro.dci.gestionapp.model.production.Bread;
import ufro.dci.gestionapp.model.production.Pizza;
import ufro.dci.gestionapp.model.shooper.Shooper;
import ufro.dci.gestionapp.repository.BreadRepository;

import java.util.List;

@Service
public class BreadService {
    final ShooperService shooperService;
    final BreadRepository breadRepository;

    public BreadService(BreadRepository breadRepository, ShooperService shooperService) {
        this.breadRepository = breadRepository;
        this.shooperService = shooperService;
    }

    public void createObjectOfBread(String name, Shooper shooper) {
        Bread bread = new Bread(name, shooper);
        saveObjectBread(bread);
    }

    public void saveObjectBread(Bread bread) {
        breadRepository.save(bread);
    }

    public List<Bread> getListBread(){
        return breadRepository.findAllByShooper(shooperService.getShooperByLastId());
    }
}
