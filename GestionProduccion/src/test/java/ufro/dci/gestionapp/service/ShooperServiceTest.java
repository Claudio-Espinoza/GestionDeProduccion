package ufro.dci.gestionapp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ufro.dci.gestionapp.model.production.Bread;
import ufro.dci.gestionapp.model.production.enumerations.DrinkEnum;
import ufro.dci.gestionapp.model.shooper.Order;
import ufro.dci.gestionapp.model.shooper.Shooper;

import java.util.List;

@SpringBootTest
class ShooperServiceTest {

    @Autowired
    OrderService orderService;
    @Autowired
    ShooperService shooperService;

    @Test
    void name() {
        Shooper shooper =  shooperService.getShooperByLastId();
        orderService.calculateCost(shooper);
    }
}

