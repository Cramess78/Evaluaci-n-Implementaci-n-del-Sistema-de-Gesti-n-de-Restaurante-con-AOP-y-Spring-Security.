package com.cristian.restaurantegarcia.repository;

import com.cristian.restaurantegarcia.entity.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
    List<Auditoria> findByUsuario(String usuario);
}