package ufro.dci.gestionapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ufro.dci.gestionapp.service.BreadService;
import ufro.dci.gestionapp.service.DrinkService;
import ufro.dci.gestionapp.service.PizzaService;
import ufro.dci.gestionapp.service.ShooperService;

//Esta anotación sirve como una especialización de @Component, permitiendo que las clases de
//implementación se detecten automáticamente a través del análisis de rutas de clase.
//Normalmente, se usa en combinación con métodos de controlador anotados basados en la anotación RequestMapping.
//Ver mas (Oficial): https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Controller.html
@Controller
public class StoreController {

    private final ShooperService shooperService;
    private final PizzaService pizzaService;
    private final DrinkService drinkService;
    private final BreadService breadService;

    public StoreController(ShooperService shooperService, PizzaService pizzaService, DrinkService drinkService, BreadService breadService) {
        this.shooperService = shooperService;
        this.pizzaService = pizzaService;
        this.drinkService = drinkService;
        this.breadService = breadService;
    }

    @GetMapping("")
    public String viewIndex() {
        return "index";
    }
    /*----|LOGIN / LOGOUT|---------------------------------------*/

    @GetMapping("/login")
    public String viewManagerLogin() {
        return "login/access-login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "index";
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/manager/home")
    public String viewManagerHome() {
        return "manager/menu/manager-home";
    }



    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/employee/home")
    public String viewEmployeeHome() {
        return "employee/menu/employee-home";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/employee/register")
    public String viewRegister() {
        return "employee/production/register";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/employee/register/back")
    public String deleteRegisterShooper() throws Exception {
        shooperService.deleteShooperForBack();
        return "employee/production/register";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/employee/make-line/back")
    public String viewMakeLineBack() {
        return "employee/production/make-line";
    }

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
        model.addAttribute("pizza", pizzaService.getListPizza());
        return "employee/production/make-line";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/delete/pizza")
    public String deletePizza(Model model){
        pizzaService.deleteByIdPizza();
        model.addAttribute("pizza", pizzaService.getListPizza());
        return "employee/production/make-line";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/employee/breads")
    public String viewBreads() {
        return "employee/production/breads";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @PostMapping("/employee/save-bread")
    public String SaveBread(String name, Model model) {
        breadService.createObjectOfBread(name, shooperService.getShooperByLastId());

        model.addAttribute("shooper", shooperService.getListShooper());
        model.addAttribute("pizza", pizzaService.getListPizza());
        model.addAttribute("bread", breadService.getListBread());
        model.addAttribute("drink", drinkService.getListDrink());

        return "employee/production/paid";
    }


    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @PostMapping("/employee/save-drinks")
    public String SaveDrinks(String drinkFlavor, String drinkSize) {
        drinkService.createObjectOfDrink( drinkFlavor, drinkSize,  shooperService.getShooperByLastId());
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

        model.addAttribute("shooper", shooperService.getListShooper());
        model.addAttribute("pizza", pizzaService.getListPizza());
        model.addAttribute("bread", breadService.getListBread());
        model.addAttribute("drink", drinkService.getListDrink());

        return "employee/production/paid"; //Cambiar
    }

}