package com.cristian.restaurantegarcia.service.Impl;

import com.cristian.restaurantegarcia.entity.Compra;
import com.cristian.restaurantegarcia.repository.CompraRepository;
import com.cristian.restaurantegarcia.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Override
    public List<Compra> listarTodas() {
        return compraRepository.findAll();
    }

    @Override
    public Compra buscarPorId(Long id) {
        return compraRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Compra compra) {
        compraRepository.save(compra);
    }

    @Override
    public void eliminar(Long id) {
        compraRepository.deleteById(id);
    }
}