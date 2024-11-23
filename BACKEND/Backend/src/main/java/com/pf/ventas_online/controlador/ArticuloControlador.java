package com.pf.ventas_online.controlador;

import com.pf.ventas_online.modelo.Articulo;
import com.pf.ventas_online.servicio.ArticuloServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articulos")
@CrossOrigin(origins = "http://localhost:3000")
public class ArticuloControlador {

    @Autowired
    private ArticuloServicio articuloServicio;

    @GetMapping
    public List<Articulo> obtenerArticulos() {
        return articuloServicio.obtenerTodosLosArticulos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Articulo> obtenerArticuloPorId(@PathVariable String id) {
        return articuloServicio.obtenerArticuloPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Articulo agregarArticulo(@RequestBody Articulo articulo) {
        return articuloServicio.agregarArticulo(articulo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Articulo> actualizarArticulo(@PathVariable String id, @RequestBody Articulo articulo) {
        return ResponseEntity.ok(articuloServicio.actualizarArticulo(id, articulo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarArticulo(@PathVariable String id) {
        articuloServicio.eliminarArticulo(id);
        return ResponseEntity.noContent().build();
    }
}
