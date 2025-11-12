package com.cristian.restaurantegarcia.service;

import com.cristian.restaurantegarcia.entity.Compra;

import java.util.List;

public interface CompraService {
    List<Compra> listarTodas();
    Compra buscarPorId(Long id);
    void guardar(Compra compra);
    void eliminar(Long id);
}
