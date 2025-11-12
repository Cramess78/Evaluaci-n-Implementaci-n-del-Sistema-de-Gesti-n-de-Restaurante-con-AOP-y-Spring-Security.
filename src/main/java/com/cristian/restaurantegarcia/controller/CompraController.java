package com.cristian.restaurantegarcia.controller;

import com.cristian.restaurantegarcia.entity.Compra;
import com.cristian.restaurantegarcia.service.CompraService;
import com.cristian.restaurantegarcia.service.ProveedorService; // ✅ importa esto
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inventario")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @Autowired
    private ProveedorService proveedorService; // ✅ agregado

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("compras", compraService.listarTodas());
        return "inventario/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("compra", new Compra());
        model.addAttribute("proveedores", proveedorService.listarTodos()); // ✅ importante
        return "inventario/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Compra compra) {
        compraService.guardar(compra);
        return "redirect:/inventario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("compra", compraService.buscarPorId(id));
        model.addAttribute("proveedores", proveedorService.listarTodos()); // ✅ también aquí si editas
        return "inventario/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        compraService.eliminar(id);
        return "redirect:/inventario";
    }
}
