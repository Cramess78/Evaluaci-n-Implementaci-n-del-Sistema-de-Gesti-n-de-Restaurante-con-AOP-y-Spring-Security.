package com.cristian.restaurantegarcia.repository;

import com.cristian.restaurantegarcia.entity.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InsumoRepository extends JpaRepository<Insumo, Long> {
    List<Insumo> findByStockLessThanEqual(double stockMinimo);
}