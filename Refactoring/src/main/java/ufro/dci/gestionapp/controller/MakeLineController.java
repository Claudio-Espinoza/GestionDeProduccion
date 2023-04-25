package ufro.dci.gestionapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MakeLineController {
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/employee/make-line")
    public String viewEmployeeHome(){
        return "employee/menu/employee-home";
    }
}
