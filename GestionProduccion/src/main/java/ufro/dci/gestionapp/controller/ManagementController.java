package ufro.dci.gestionapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ufro.dci.gestionapp.service.ManagerService;

@Controller
public class ManagementController {

    private final ManagerService managerService;

    public ManagementController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/manager/home")
    public String viewManagerHome(){
        return "manager/management/general-management";
    }

    @GetMapping("/manager/info")
    public String showManagerData(Model model){
        String nombre = managerService.getEmployeeName();
        String apellido = managerService.getEmployeeLastName();
        model.addAttribute("nombre", nombre);
        model.addAttribute("apellido", apellido);
        return "/manager/management/general-management";
    }
    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/manager/clients")
    public String viewClients(){
        return "manager/management/view-clients";
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/manager/pizzas")
    public String viewPizzas(){
        return "manager/management/view-pizzas";
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/manager/drinks")
    public String viewDrinks(){
        return "manager/management/view-drinks";
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/manager/bakery")
    public String viewBakery(){
        return "manager/management/view-bakery";
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/manager/orders")
    public String viewOrders(){
        return "manager/management/view-orders";
    }


}
