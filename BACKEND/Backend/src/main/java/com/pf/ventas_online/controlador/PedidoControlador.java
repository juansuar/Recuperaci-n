package com.pf.ventas_online.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.pf.ventas_online.modelo.Pedido;
import com.pf.ventas_online.servicio.PedidoServicio;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "http://localhost:3000")
public class PedidoControlador {

    @Autowired
    private PedidoServicio pedidoServicio;

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obtenerPedidoPorId(@PathVariable String id) {
        Optional<Pedido> pedido = pedidoServicio.obtenerPedidoPorId(id);
        return ResponseEntity.ok(pedido.get());
    }

    @PostMapping
    public ResponseEntity<Pedido> registrarPedido(@RequestBody Pedido pedido) {
        Pedido nuevoPedido = pedidoServicio.registrarPedido(pedido);
        return ResponseEntity.ok(nuevoPedido);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> obtenerTodosLosPedidos() {
        List<Pedido> pedidos = pedidoServicio.obtenerTodosLosPedidos();
        return ResponseEntity.ok(pedidos);
    }
}
