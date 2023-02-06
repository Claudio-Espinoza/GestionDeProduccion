package ufro.dci.gestionapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    public StoreController(ShooperService shooperService, PizzaService pizzaService) {
        this.shooperService = shooperService;
        this.pizzaService = pizzaService;
    }

    @GetMapping("")
    public String viewIndex(){
        return "index";
    }

    @GetMapping("/login")
    public String viewManagerLogin(){
        return "login/access-login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "index";
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/manager/home")
    public String viewManagerHome(){
        return "manager/menu/manager-home";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/employee/home")
    public String viewEmployeeHome(){
        return "employee/menu/employee-home";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/employee/register")
    public String viewRegister(){
        return "employee/production/register";}

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @PostMapping("/employee/make-line")
    public String saveUser(String name, String phone, String meansDelivery, String commentary){
        shooperService.createObject(name, phone, meansDelivery, commentary);

        return "employee/production/make-line";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @PostMapping("/employee/drinks")
    public String viewDrinks() {
        return "employee/production/drinks";
    }
    @PostMapping("/employee/save-pizza")
    public String savePizza(String name,  Model model){
        pizzaService.createObject(name, shooperService.getShooperByLastId());
        model.addAttribute("pizza", pizzaService.getListPizza());
        return "employee/production/make-line";
    }
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @PostMapping("/employee/breads")
    public String viewBreads() {
        return "employee/production/breads";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/delete/pizza")
    public String deletePizza(Model model){
        pizzaService.deleteByIdPizza();
        model.addAttribute("pizza", pizzaService.getListPizza());
        return "employee/production/make-line";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/employee/drinks")
    public String viewMakeLine() {

        //Guardar los consumibles
        //Necesita saber la id del usuario comprador

        return "employee/production/drinks"; //Cambiar
    }
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/employee/paid")
    public String viewPaid() {

        //Guardar panes
        //Necesita saber la id del usuario comprador
        //realizar el calculo del precio total y mostrarlo en vistas

        return "employee/production/paid"; //Cambiar
    }
}
