package com.cristian.restaurantegarcia.service.Impl;

import com.cristian.restaurantegarcia.entity.Bitacora;
import com.cristian.restaurantegarcia.repository.BitacoraRepository;
import com.cristian.restaurantegarcia.service.BitacoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BitacoraServiceImpl implements BitacoraService {

    @Autowired
    private BitacoraRepository bitacoraRepository;

    @Override
    public void registrar(String accion, String entidad, String usuario, String detalle) {
        Bitacora b = new Bitacora();
        b.setAccion(accion);
        b.setEntidad(entidad);
        b.setUsuario(usuario);
        b.setDetalle(detalle);
        b.setFechaHora(LocalDateTime.now());
        bitacoraRepository.save(b);
    }

    @Override
    public List<Bitacora> listarTodas() {
        return bitacoraRepository.findAll();
    }
}
