package ufro.dci.gestionapp.service;

import org.springframework.stereotype.Service;
import ufro.dci.gestionapp.model.shooper.Shooper;
import ufro.dci.gestionapp.repository.ShooperRepository;

import java.util.List;

@Service
public class ShooperService {
    final
    ShooperRepository shooperRepository;
    public ShooperService(ShooperRepository shooperRepository) {
        this.shooperRepository = shooperRepository;
    }

    public void createObject(String name, String phone, String meansDelivery, String commentary){
        Shooper shooper = new Shooper(name, phone, meansDelivery, commentary);
        saveObjeto(shooper);
    }
    private void saveObjeto(Shooper shooper){
        shooperRepository.save(shooper);
    }

    private int getLastId(){
        List<Shooper> lastId=shooperRepository.findAll();
        return lastId.get(lastId.size()-1).getId();
    }

    public Shooper getShooperByLastId(){
        int lastId=getLastId();
        return shooperRepository.findById(lastId);
    }

    public List<Shooper> getListShooper(){
        return shooperRepository.findAllById(getLastId());
    }


    public void deleteShooperForBack() throws Exception{
            shooperRepository.deleteById(getLastId());

    }
}
