package com.cristian.restaurantegarcia.service;

import com.cristian.restaurantegarcia.entity.Factura;

import java.util.List;

public interface FacturaService {
    List<Factura> listarTodas();
    Factura buscarPorId(Long id);
    void guardar(Factura factura);
    void eliminar(Long id);
}