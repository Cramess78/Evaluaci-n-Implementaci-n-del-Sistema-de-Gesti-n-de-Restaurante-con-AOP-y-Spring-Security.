package com.cristian.restaurantegarcia.repository;

import com.cristian.restaurantegarcia.entity.Rol;
import com.cristian.restaurantegarcia.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombreUsuario(String nombreUsuario);
    List<Usuario> findByRolesContaining(Rol rol);
}