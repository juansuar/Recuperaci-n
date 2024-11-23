package com.pf.ventas_online.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pf.ventas_online.modelo.Movimiento;
import com.pf.ventas_online.servicio.MovimientoServicio;

import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
@CrossOrigin(origins = "http://localhost:3000")
public class MovimientoControlador {

    @Autowired
    private MovimientoServicio movimientoServicio;

    @GetMapping
    public List<Movimiento> obtenerTodosLosMovimientos() {
        return movimientoServicio.obtenerTodosLosMovimientos();
    }

    @PostMapping
    public Movimiento agregarMovimiento(@RequestBody Movimiento movimiento) {
        return movimientoServicio.agregarMovimiento(movimiento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMovimiento(@PathVariable String id) {
        movimientoServicio.eliminarMovimiento(id);
        return ResponseEntity.ok().build();
    }
}
