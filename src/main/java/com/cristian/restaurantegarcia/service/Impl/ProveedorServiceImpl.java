package com.cristian.restaurantegarcia.service.Impl;

import com.cristian.restaurantegarcia.entity.Proveedor;
import com.cristian.restaurantegarcia.repository.ProveedorRepository;
import com.cristian.restaurantegarcia.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;
    @Override
    public List<Proveedor> listarTodos() {
        return proveedorRepository.findAll();
    }
    @Override
    public void guardar(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }
    @Override
    public Proveedor buscarPorId(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }
    @Override
    public void eliminar(Long id) {
        proveedorRepository.deleteById(id);
    }
}
