package ufro.dci.gestionapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ufro.dci.gestionapp.model.shooper.Shooper;
import ufro.dci.gestionapp.service.*;

//Esta anotación sirve como una especialización de @Component, permitiendo que las clases de
//implementación se detecten automáticamente a través del análisis de rutas de clase.
//Normalmente, se usa en combinación con métodos de controlador anotados basados en la anotación RequestMapping.
//Ver mas (Oficial): https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Controller.html
@Controller
public class StoreController {
//-|Constructor de la clase|-----------------------------------------------------------------------------------------//
    //Es una forma de inyeccion de dependecia recomendada por la documentacion de Spring Boot. Dentro de las recomendaciones
    //tambien se encuentra una estructura de getter y setter pero en este caso era mas estable el uso de un constructor
    private final ShooperService shooperService;
    private final PizzaService pizzaService;
    private final DrinkService drinkService;
    private final BreadService breadService;
    private final OrderService orderService;
    public StoreController(ShooperService shooperService, PizzaService pizzaService, DrinkService drinkService, BreadService breadService, OrderService orderService) {
        this.shooperService = shooperService;
        this.pizzaService = pizzaService;
        this.drinkService = drinkService;
        this.breadService = breadService;
        this.orderService = orderService;
    }

    //-|Mapping|--------------------------------------------------------------------------------------//
    @GetMapping("")
    public String viewIndex() {
        return "index";
    }

    @GetMapping("/login")
    public String viewManagerLogin() {
        return "login/access-login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "index";
    }
    //-|Mapping / Get|-----------------------------------------------------------------------------------------------//
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/employee/home")
    public String viewEmployeeHome() {
        return "employee/menu/employee-home";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/employee/client-list")
    public String viewClients(Model model) {
        model.addAttribute("shooper", shooperService.getAllShooper());
        return "employee/menu/client-list";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/employee/register")
    public String viewRegister() {
        return "employee/production/register";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/employee/register/back")
    public String deleteRegisterShooper() {
        shooperService.deleteShooperForBack();
        return "employee/production/register";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/employee/make-line/back")
    public String viewMakeLineBack() {
        return "employee/production/make-line";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/employee/breads")
    public String viewBreads() {
        return "employee/production/breads";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/employee/drinks")
    public String viewDrinks() {
        return "employee/production/drinks";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/employee/paid")
    public String viewPaid(Model model) {
        Shooper shooper = shooperService.getShooperByLastId();

        int cost = orderService.calculateCost(
                pizzaService.getCostPizzaOfOrder(shooper),
                breadService.calculateCostBread(shooper),
                drinkService.calculateCostDrink(shooper));

        model.addAttribute("shooper", shooperService.getListShooper());
        model.addAttribute("cost", cost);
        model.addAttribute("pizza", pizzaService.getListPizza(shooper));
        model.addAttribute("bread", breadService.getListBread(shooper));
        model.addAttribute("drink", drinkService.getListDrink(shooper));
        return "employee/production/paid";
    }

    //-|Mapping / Post|----------------------------------------------------------------------------------------------//
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @PostMapping("/employee/make-line")
    public String saveUser(String name, String phone, String meansDelivery, String commentary){
        shooperService.createObject(name, phone, meansDelivery, commentary);

        return "employee/production/make-line";
    }
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @PostMapping("/employee/save-pizza")
    public String savePizza(String name,  Model model){
        pizzaService.createObject(name, shooperService.getShooperByLastId());
        model.addAttribute("pizza", pizzaService.getListPizza(shooperService.getShooperByLastId()));
        return "employee/production/make-line";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/delete/pizza")
    public String deletePizza(Model model){
        pizzaService.deleteLastIdPizza();
        model.addAttribute("pizza", pizzaService.getListPizza(shooperService.getShooperByLastId()));
        return "employee/production/register";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @PostMapping("/employee/save-bread")
    public String SaveBread(String name, Model model) {
        Shooper shooper = shooperService.getShooperByLastId();

        breadService.createObjectOfBread(name, shooper);

        int cost = orderService.calculateCost(
                pizzaService.getCostPizzaOfOrder(shooper),
                breadService.calculateCostBread(shooper),
                drinkService.calculateCostDrink(shooper));

        model.addAttribute("shooper", shooper);
        model.addAttribute("cost", cost);
        model.addAttribute("pizza", pizzaService.getListPizza(shooper));
        model.addAttribute("bread", breadService.getListBread(shooper));
        model.addAttribute("drink", drinkService.getListDrink(shooper));



        return "employee/production/paid";
    }


    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @PostMapping("/employee/save-drinks")
    public String SaveDrinks(String drinkFlavor, String drinkSize) {
        drinkService.createObjectOfDrink( drinkFlavor, drinkSize,  shooperService.getShooperByLastId());
        return "employee/production/breads";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @PostMapping("/employee/paid-save")
    public String viewPaid(String typePaid) {
        Shooper shooper = shooperService.getShooperByLastId();

        int cost = orderService.calculateCost(
                pizzaService.getCostPizzaOfOrder(shooper),
                drinkService.calculateCostDrink(shooper),
                breadService.calculateCostBread(shooper)
                );

        orderService.createOrderObject(
                cost,
                shooperService.getNameShooper(shooper),
                typePaid,
                pizzaService.getListPizza(shooper).size(),
                breadService.getListBread(shooper).size(),
                drinkService.getListDrink(shooper).size(),
                shooper
        );


        return "employee/menu/employee-home";
    }

}