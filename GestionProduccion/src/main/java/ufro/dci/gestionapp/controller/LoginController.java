package ufro.dci.gestionapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Esta anotación sirve como una especialización de @Component, permitiendo que las clases de
//implementación se detecten automáticamente a través del análisis de rutas de clase.
//Normalmente, se usa en combinación con métodos de controlador anotados basados en la anotación RequestMapping.
//Ver mas (Oficial): https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Controller.html
@Controller
@RequestMapping
public class LoginController {

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/login/employee")
    public String initial(){
        return "login/employee/login-employee";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/login/admin")
    public String loginAdmin(){
        return "login/admin/login-admin";
    }


}
