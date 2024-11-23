package com.pf.ventas_online.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.pf.ventas_online.modelo.Pedido;

@Repository
public interface PedidoRepositorio extends MongoRepository<Pedido, String> {
    
}
