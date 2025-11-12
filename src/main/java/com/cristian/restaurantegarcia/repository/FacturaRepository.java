package com.cristian.restaurantegarcia.repository;

import com.cristian.restaurantegarcia.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
    List<Factura> findByEstado(Factura.EstadoFactura estado);
    List<Factura> findByMetodoPago(Factura.MetodoPago metodoPago);
}