package com.cristian.restaurantegarcia.service.Impl;

import com.cristian.restaurantegarcia.entity.Pedido;
import com.cristian.restaurantegarcia.repository.PedidoRepository;
import com.cristian.restaurantegarcia.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Override
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }
    @Override
    public void guardar(Pedido pedido) {
        pedidoRepository.save(pedido);
    }
    @Override
    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }
    @Override
    public void eliminar(Long id) {
        pedidoRepository.deleteById(id);
    }
}
