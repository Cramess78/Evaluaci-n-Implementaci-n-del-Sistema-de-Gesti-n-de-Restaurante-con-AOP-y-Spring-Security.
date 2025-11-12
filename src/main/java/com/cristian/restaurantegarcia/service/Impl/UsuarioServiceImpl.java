package com.cristian.restaurantegarcia.service.Impl;

import com.cristian.restaurantegarcia.entity.Usuario;
import com.cristian.restaurantegarcia.repository.UsuarioRepository;
import com.cristian.restaurantegarcia.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
    @Override
    public Usuario buscarPorNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    @Override
    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
