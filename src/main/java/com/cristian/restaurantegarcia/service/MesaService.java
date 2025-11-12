package com.cristian.restaurantegarcia.service;

import com.cristian.restaurantegarcia.entity.Mesa;

import java.util.List;

public interface MesaService {
    List<Mesa> listarTodas();
    Mesa buscarPorId(Long id);
    void guardar(Mesa mesa);
    void eliminar(Long id);
}