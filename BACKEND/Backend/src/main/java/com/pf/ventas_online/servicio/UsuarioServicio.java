package com.pf.ventas_online.servicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pf.ventas_online.modelo.Usuario;
import com.pf.ventas_online.repositorio.UsuarioRepositorio;

import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public Usuario registrarUsuario(Usuario usuario) throws Exception {
        Optional<Usuario> usuarioExistente = usuarioRepositorio.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new Exception("El usuario con este email ya existe.");
        }
        return usuarioRepositorio.save(usuario);
    }

    public Usuario iniciarSesion(String email, String password) {
        Optional<Usuario> optionalUsuario = usuarioRepositorio.findByEmail(email);
    
        if (optionalUsuario.isPresent() && optionalUsuario.get().getPassword().equals(password)) {
            return optionalUsuario.get();
        }
        return null;
    }
    


    public Usuario obtenerUsuarioPorId(String id) {
    return usuarioRepositorio.findById(id).orElseThrow();
}

    public Optional<Usuario> obtenerUsuarioPorEmail(String email) {
        return usuarioRepositorio.findByEmail(email);
    }

    public void eliminarUsuario(String id) {
        usuarioRepositorio.deleteById(id);
    }
}

