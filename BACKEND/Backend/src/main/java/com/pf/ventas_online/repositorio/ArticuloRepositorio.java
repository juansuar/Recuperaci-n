package com.pf.ventas_online.repositorio;

import com.pf.ventas_online.modelo.Articulo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepositorio extends MongoRepository<Articulo, String> {

}
