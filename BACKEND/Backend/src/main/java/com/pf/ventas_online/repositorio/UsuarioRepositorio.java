package com.pf.ventas_online.repositorio;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pf.ventas_online.modelo.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByEmail(String email);  
}
