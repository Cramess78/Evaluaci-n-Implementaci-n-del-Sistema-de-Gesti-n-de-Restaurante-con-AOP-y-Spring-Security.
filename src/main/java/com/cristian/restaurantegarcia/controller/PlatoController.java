package com.cristian.restaurantegarcia.controller;

import com.cristian.restaurantegarcia.entity.Plato;
import com.cristian.restaurantegarcia.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/platos")
public class PlatoController {

    @Autowired
    private PlatoService platoService;
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("platos", platoService.listarTodos());
        return "plato/listar";
    }
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("plato", new Plato());
        return "plato/formulario";
    }
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Plato plato) {
        platoService.guardar(plato);
        return "redirect:/platos";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("plato", platoService.buscarPorId(id));
        return "plato/formulario";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        platoService.eliminar(id);
        return "redirect:/platos";
    }
}