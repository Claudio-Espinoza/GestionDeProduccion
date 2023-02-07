package ufro.dci.gestionapp.service;

import org.springframework.stereotype.Service;
import ufro.dci.gestionapp.model.production.Bread;
import ufro.dci.gestionapp.model.shooper.Shooper;
import ufro.dci.gestionapp.repository.BreadRepository;

@Service
public class BreadService {
    final BreadRepository breadRepository;

    public BreadService(BreadRepository breadRepository) {
        this.breadRepository = breadRepository;
    }

    public void createObjectOfBread(String name, Shooper shooper) {
        Bread bread = new Bread(name, shooper);
        saveObjectBread(bread);
    }

    public void saveObjectBread(Bread bread) {
        breadRepository.save(bread);
    }
}
