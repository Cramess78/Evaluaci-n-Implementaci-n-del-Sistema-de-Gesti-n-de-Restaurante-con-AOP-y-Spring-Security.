package com.cristian.restaurantegarcia.service.Impl;

import com.cristian.restaurantegarcia.entity.Rol;
import com.cristian.restaurantegarcia.repository.RolRepository;
import com.cristian.restaurantegarcia.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolRepository rolRepository;
    @Override
    public List<Rol> listarTodos() {
        return rolRepository.findAll();
    }
}