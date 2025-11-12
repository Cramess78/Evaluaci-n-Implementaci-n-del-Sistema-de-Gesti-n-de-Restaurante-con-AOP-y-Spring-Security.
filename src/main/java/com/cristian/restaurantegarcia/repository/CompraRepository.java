package com.cristian.restaurantegarcia.repository;

import com.cristian.restaurantegarcia.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    List<Compra> findByProveedor_IdProveedor(Long idProveedor);
}
