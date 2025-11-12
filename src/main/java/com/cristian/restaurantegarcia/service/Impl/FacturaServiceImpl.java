package com.cristian.restaurantegarcia.service.Impl;

import com.cristian.restaurantegarcia.entity.Factura;
import com.cristian.restaurantegarcia.repository.FacturaRepository;
import com.cristian.restaurantegarcia.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public List<Factura> listarTodas() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura buscarPorId(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Factura factura) {
        facturaRepository.save(factura);
    }

    @Override
    public void eliminar(Long id) {
        facturaRepository.deleteById(id);
    }
}