package ufro.dci.gestionapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ufro.dci.gestionapp.service.*;

@Controller
public class ManagementController {

    private final ManagerService managerService;
    private final BreadService breadService;
    private final PizzaService pizzaService;
    private final ShooperService shooperService;
    private final DrinkService drinkService;
    private final OrderService orderService;

    public ManagementController(ManagerService managerService, BreadService breadService, PizzaService pizzaService, ShooperService shooperService, DrinkService drinkService, OrderService orderService) {
        this.managerService = managerService;
        this.breadService = breadService;
        this.pizzaService = pizzaService;
        this.shooperService = shooperService;
        this.drinkService = drinkService;
        this.orderService = orderService;
    }

    /*----- |Mostrar nombre manager|----------------------------------------------------*/
    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/manager/home")
    public String viewManagerHome(Model model){
        model.addAttribute("nombre", managerService.getManagerName());
        return "manager/management/general-management";
    }

    /*----- |Mostrar vistas|----------------------------------------------------*/
    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/manager/clients")
    public String viewClients(Model model){
        model.addAttribute("nombre", managerService.getManagerName());
        model.addAttribute("shooper", shooperService.getAllShooper());
        return "manager/management/view-clients";
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/manager/pizzas")
    public String viewPizzas(Model model){
        model.addAttribute("nombre", managerService.getManagerName());
        model.addAttribute("pizza", pizzaService.getAllPizza());
        return "manager/management/view-pizzas";
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/manager/drinks")
    public String viewDrinks(Model model){
        model.addAttribute("nombre", managerService.getManagerName());
        model.addAttribute("drink", drinkService.getAllDrink());

        return "manager/management/view-drinks";
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/manager/bakery")
    public String viewBakery(Model model){
        model.addAttribute("nombre", managerService.getManagerName());
        model.addAttribute("bread", breadService.getListBread(shooperService.getShooperByLastId()));
        return "manager/management/view-bakery";
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/manager/orders")
    public String viewOrders(Model model){
        model.addAttribute("nombre", managerService.getManagerName());
        model.addAttribute("order", orderService.getListOfOrder());
        return "manager/management/view-orders";
    }

}
