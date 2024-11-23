package com.pf.ventas_online.repositorio;

import com.pf.ventas_online.modelo.Contacto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactoRepositorio extends MongoRepository<Contacto, String> {
    List<Contacto> findByEmpresaId(String empresaId);

    void deleteByEmpresaId(String empresaId);
}
