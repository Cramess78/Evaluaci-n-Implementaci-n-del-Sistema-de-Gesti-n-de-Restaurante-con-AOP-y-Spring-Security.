package com.cristian.restaurantegarcia.controller;

import com.cristian.restaurantegarcia.entity.Factura;
import com.cristian.restaurantegarcia.service.FacturaService;
import com.cristian.restaurantegarcia.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ventas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private PedidoService pedidoService;
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("facturas", facturaService.listarTodas());
        return "ventas/listar";
    }
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("factura", new Factura());
        model.addAttribute("pedidos", pedidoService.listarTodos()); // <<<<<< pedidos disponibles
        return "ventas/formulario";
    }
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Factura factura) {
        facturaService.guardar(factura);
        return "redirect:/ventas";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("factura", facturaService.buscarPorId(id));
        model.addAttribute("pedidos", pedidoService.listarTodos()); // <<<<<< también para edición
        return "ventas/formulario";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        facturaService.eliminar(id);
        return "redirect:/ventas";
    }
}
