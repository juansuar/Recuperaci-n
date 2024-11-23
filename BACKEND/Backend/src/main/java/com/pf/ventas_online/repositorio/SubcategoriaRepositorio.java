package com.pf.ventas_online.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.pf.ventas_online.modelo.Subcategoria;

@Repository
public interface SubcategoriaRepositorio extends MongoRepository<Subcategoria, String> {
    List<Subcategoria> findByCategoriaId(String categoriaId);
}
