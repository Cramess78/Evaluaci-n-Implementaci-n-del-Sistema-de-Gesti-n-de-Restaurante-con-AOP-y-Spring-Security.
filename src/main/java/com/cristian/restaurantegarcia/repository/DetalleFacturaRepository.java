package com.cristian.restaurantegarcia.repository;

import com.cristian.restaurantegarcia.entity.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Long> {
    List<DetalleFactura> findByFactura_IdFactura(Long idFactura);
}
