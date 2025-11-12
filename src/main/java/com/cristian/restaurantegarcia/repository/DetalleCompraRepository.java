package com.cristian.restaurantegarcia.repository;

import com.cristian.restaurantegarcia.entity.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Long> {
    List<DetalleCompra> findByCompra_IdCompra(Long idCompra);
}
