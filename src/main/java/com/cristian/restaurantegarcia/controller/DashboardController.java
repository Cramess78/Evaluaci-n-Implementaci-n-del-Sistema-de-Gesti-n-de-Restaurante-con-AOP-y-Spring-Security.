package com.cristian.restaurantegarcia.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String mostrarDashboard() {
        return "dashboard"; // busca en src/main/resources/templates/dashboard.html
    }
}
