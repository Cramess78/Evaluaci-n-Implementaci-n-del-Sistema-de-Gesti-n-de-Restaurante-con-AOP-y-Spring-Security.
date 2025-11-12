package com.cristian.restaurantegarcia.service;

import com.cristian.restaurantegarcia.entity.Bitacora;
import java.util.List;

public interface BitacoraService {
    void registrar(String accion, String entidad, String usuario, String detalle);
    List<Bitacora> listarTodas();
}
