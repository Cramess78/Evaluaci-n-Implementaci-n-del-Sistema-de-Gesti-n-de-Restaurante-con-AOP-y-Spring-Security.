package com.cristian.restaurantegarcia.controller;

import com.cristian.restaurantegarcia.service.BitacoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bitacora")
public class BitacoraController {

    @Autowired
    private BitacoraService bitacoraService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("bitacoras", bitacoraService.listarTodas());
        return "admin/bitacora/listar"; // Ruta al template
    }
}
