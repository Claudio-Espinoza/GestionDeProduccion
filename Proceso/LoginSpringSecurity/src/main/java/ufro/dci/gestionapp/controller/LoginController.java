package ufro.dci.gestionapp.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Esta anotación sirve como una especialización de @Component, permitiendo que las clases de
//implementación se detecten automáticamente a través del análisis de rutas de clase.
//Normalmente, se usa en combinación con métodos de controlador anotados basados en la anotación RequestMapping.
//Ver mas (Oficial): https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Controller.html
@Controller
public class LoginController {
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
}
