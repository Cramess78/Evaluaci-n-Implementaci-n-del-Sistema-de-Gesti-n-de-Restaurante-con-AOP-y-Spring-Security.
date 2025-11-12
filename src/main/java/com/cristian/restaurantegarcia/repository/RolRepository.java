package com.cristian.restaurantegarcia.repository;

import com.cristian.restaurantegarcia.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Rol findByNombre(String nombre);
}