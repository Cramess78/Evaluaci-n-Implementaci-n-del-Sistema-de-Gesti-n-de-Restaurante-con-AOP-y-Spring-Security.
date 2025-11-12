package com.cristian.restaurantegarcia.service;

import com.cristian.restaurantegarcia.entity.Proveedor;
import java.util.List;

public interface ProveedorService {
    List<Proveedor> listarTodos();
    void guardar(Proveedor proveedor);
    Proveedor buscarPorId(Long id);
    void eliminar(Long id);
}
