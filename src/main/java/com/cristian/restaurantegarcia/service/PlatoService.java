package com.cristian.restaurantegarcia.service;

import com.cristian.restaurantegarcia.entity.Plato;

import java.util.List;

public interface PlatoService {
    List<Plato> listarTodos();
    Plato buscarPorId(Long id);
    void guardar(Plato plato);
    void eliminar(Long id);
}