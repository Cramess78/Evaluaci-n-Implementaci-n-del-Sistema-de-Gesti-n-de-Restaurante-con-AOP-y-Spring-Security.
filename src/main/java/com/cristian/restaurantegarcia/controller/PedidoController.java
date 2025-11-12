package com.cristian.restaurantegarcia.controller;

import com.cristian.restaurantegarcia.entity.Cliente;
import com.cristian.restaurantegarcia.entity.Mesa;
import com.cristian.restaurantegarcia.entity.Pedido;
import com.cristian.restaurantegarcia.service.ClienteService;
import com.cristian.restaurantegarcia.service.MesaService;
import com.cristian.restaurantegarcia.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.beans.PropertyEditorSupport;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private MesaService mesaService;
    @Autowired
    private ClienteService clienteService;
    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(Cliente.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String id) {
                if (id != null && !id.isEmpty()) {
                    setValue(clienteService.buscarPorId(Long.parseLong(id)));
                } else {
                    setValue(null);
                }
            }
        });

        binder.registerCustomEditor(Mesa.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String id) {
                if (id != null && !id.isEmpty()) {
                    setValue(mesaService.buscarPorId(Long.parseLong(id)));
                } else {
                    setValue(null);
                }
            }
        });
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pedidos", pedidoService.listarTodos());
        return "pedido/listar";
    }
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("mesas", mesaService.listarTodas());
        model.addAttribute("clientes", clienteService.listarTodos());
        return "pedido/formulario";
    }
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Pedido pedido) {
        pedidoService.guardar(pedido);
        return "redirect:/pedidos";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("pedido", pedidoService.buscarPorId(id));
        model.addAttribute("mesas", mesaService.listarTodas());
        model.addAttribute("clientes", clienteService.listarTodos());
        return "pedido/formulario";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        pedidoService.eliminar(id);
        return "redirect:/pedidos";
    }
}
