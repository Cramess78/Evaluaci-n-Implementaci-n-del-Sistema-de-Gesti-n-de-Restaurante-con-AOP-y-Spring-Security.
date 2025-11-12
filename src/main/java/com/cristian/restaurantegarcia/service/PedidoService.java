package com.cristian.restaurantegarcia.service;


import com.cristian.restaurantegarcia.entity.Pedido;
import java.util.List;


public interface PedidoService {
    List<Pedido> listarTodos();
    void guardar(Pedido pedido);
    Pedido buscarPorId(Long id);
    void eliminar(Long id);
}
