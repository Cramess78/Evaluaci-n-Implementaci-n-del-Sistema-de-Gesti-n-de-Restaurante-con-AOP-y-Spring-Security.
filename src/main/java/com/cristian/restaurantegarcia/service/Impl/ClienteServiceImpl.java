package com.cristian.restaurantegarcia.service.Impl;

import com.cristian.restaurantegarcia.entity.Cliente;
import com.cristian.restaurantegarcia.repository.ClienteRepository;
import com.cristian.restaurantegarcia.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }
    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
    @Override
    public void guardar(Cliente cliente) {
        clienteRepository.save(cliente);
    }
    @Override
    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }
}