package com.cristian.restaurantegarcia.repository;

import com.cristian.restaurantegarcia.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MesaRepository extends JpaRepository<Mesa, Long> {
    List<Mesa> findByEstado(Mesa.EstadoMesa estado);
}