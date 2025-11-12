package com.cristian.restaurantegarcia.service.Impl;

import com.cristian.restaurantegarcia.entity.Mesa;
import com.cristian.restaurantegarcia.repository.MesaRepository;
import com.cristian.restaurantegarcia.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaServiceImpl implements MesaService {

    @Autowired
    private MesaRepository mesaRepository;
    @Override
    public List<Mesa> listarTodas() {
        return mesaRepository.findAll();
    }
    @Override
    public Mesa buscarPorId(Long id) {
        return mesaRepository.findById(id).orElse(null);
    }
    @Override
    public void guardar(Mesa mesa) {
        mesaRepository.save(mesa);
    }
    @Override
    public void eliminar(Long id) {
        mesaRepository.deleteById(id);
    }
}