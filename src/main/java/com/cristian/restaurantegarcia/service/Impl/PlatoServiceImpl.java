package com.cristian.restaurantegarcia.service.Impl;

import com.cristian.restaurantegarcia.entity.Plato;
import com.cristian.restaurantegarcia.repository.PlatoRepository;
import com.cristian.restaurantegarcia.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoServiceImpl implements PlatoService {

    @Autowired
    private PlatoRepository platoRepository;
    @Override
    public List<Plato> listarTodos() {
        return platoRepository.findAll();
    }
    @Override
    public Plato buscarPorId(Long id) {
        return platoRepository.findById(id).orElse(null);
    }
    @Override
    public void guardar(Plato plato) {
        platoRepository.save(plato);
    }
    @Override
    public void eliminar(Long id) {
        platoRepository.deleteById(id);
    }
}