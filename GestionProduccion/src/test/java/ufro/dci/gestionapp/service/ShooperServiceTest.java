package ufro.dci.gestionapp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ufro.dci.gestionapp.model.shooper.Shooper;
import ufro.dci.gestionapp.repository.PizzaRepository;
import ufro.dci.gestionapp.repository.ShooperRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShooperServiceTest {

    @Autowired
    PizzaRepository pizzaRepository;

    @Autowired
    ShooperService shooperService;
}