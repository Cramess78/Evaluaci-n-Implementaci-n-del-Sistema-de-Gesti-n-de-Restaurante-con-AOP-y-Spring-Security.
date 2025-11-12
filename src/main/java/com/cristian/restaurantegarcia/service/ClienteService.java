package com.cristian.restaurantegarcia.service;

import com.cristian.restaurantegarcia.entity.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> listarTodos();
    Cliente buscarPorId(Long id);
    void guardar(Cliente cliente);
    void eliminar(Long id);
}