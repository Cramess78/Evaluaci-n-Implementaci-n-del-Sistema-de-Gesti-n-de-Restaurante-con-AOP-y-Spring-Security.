package com.cristian.restaurantegarcia.repository;

import com.cristian.restaurantegarcia.entity.Plato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlatoRepository extends JpaRepository<Plato, Long> {
    List<Plato> findByEstadoTrue();
}