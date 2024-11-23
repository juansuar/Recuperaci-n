package com.pf.ventas_online.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.pf.ventas_online.modelo.Articulo;
import com.pf.ventas_online.modelo.ArticuloPedido;
import com.pf.ventas_online.modelo.Pedido;
import com.pf.ventas_online.repositorio.ArticuloRepositorio;
import com.pf.ventas_online.repositorio.PedidoRepositorio;

@Service
public class PedidoServicio {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private ArticuloRepositorio articuloRepositorio;

    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoRepositorio.findAll();
    }

    public Optional<Pedido> obtenerPedidoPorId(String id) {
        return pedidoRepositorio.findById(id);
    }

    public Pedido registrarPedido(Pedido pedido) {
        for (ArticuloPedido articuloPedido : pedido.getArticulos()) {
            Articulo articulo = articuloRepositorio.findById(articuloPedido.getArticuloId())
                    .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));
            if (pedido.getTipoPedido().equals("Compra")) {
                articulo.setStock(articulo.getStock() + articuloPedido.getCantidad());
            } else {
                articulo.setStock(articulo.getStock() - articuloPedido.getCantidad());
            }
            articuloRepositorio.save(articulo);
        }
        return pedidoRepositorio.save(pedido);
    }

}
