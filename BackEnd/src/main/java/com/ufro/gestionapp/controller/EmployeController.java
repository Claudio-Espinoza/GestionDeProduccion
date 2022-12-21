package com.ufro.gestionapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee/")
public class EmployeController {

    @GetMapping(value ="/login")
    public void initianPageEmployee(){
        System.out.println("A");
    }
}
