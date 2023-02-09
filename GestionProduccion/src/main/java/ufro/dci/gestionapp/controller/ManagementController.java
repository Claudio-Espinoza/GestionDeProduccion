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

    @GetMapping("/")
    public String showManagerData(Model model){
        String nombre = managerService.getEmployeeName();
        String apellido = managerService.getEmployeeLastName();
        model.addAttribute("nombre", nombre);
        model.addAttribute("apellido", apellido);
        return "/manager/management/general-management";
    }


}
