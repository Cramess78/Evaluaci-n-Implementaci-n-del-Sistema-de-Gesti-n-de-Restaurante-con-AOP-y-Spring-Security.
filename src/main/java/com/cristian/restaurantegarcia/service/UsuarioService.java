package com.cristian.restaurantegarcia.service;

import com.cristian.restaurantegarcia.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listarTodos();
    Usuario buscarPorId(Long id);
    Usuario buscarPorNombreUsuario(String nombreUsuario);
    void guardar(Usuario usuario);
    void eliminar(Long id);
}