package com.pf.ventas_online.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pf.ventas_online.modelo.Subcategoria;
import com.pf.ventas_online.servicio.SubcategoriaServicio;

import java.util.List;

@RestController
@RequestMapping("/api/subcategorias")
@CrossOrigin(origins = "http://localhost:3000")
public class SubcategoriaControlador {

    @Autowired
    private SubcategoriaServicio subcategoriaServicio;

    @GetMapping
    public List<Subcategoria> obtenerSubcategorias() {
        return subcategoriaServicio.obtenerSubcategorias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subcategoria> obtenerSubcategoria(@PathVariable String id) {
        return subcategoriaServicio.obtenerSubcategoriaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/categorias/{categoriaId}")
    public ResponseEntity<List<Subcategoria>> obtenerSubcategoriasPorCategoria(@PathVariable String categoriaId) {
        List<Subcategoria> subcategorias = subcategoriaServicio.obtenerSubcategoriasPorCategoria(categoriaId);
        if (subcategorias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(subcategorias);
    }

    @PostMapping
    public Subcategoria crearSubcategoria(@RequestBody Subcategoria subcategoria) {
        return subcategoriaServicio.crearSubcategoria(subcategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subcategoria> actualizarSubcategoria(
            @PathVariable String id, @RequestBody Subcategoria subcategoria) {
        return ResponseEntity.ok(subcategoriaServicio.actualizarSubcategoria(id, subcategoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSubcategoria(@PathVariable String id) {
        subcategoriaServicio.eliminarSubcategoria(id);
        return ResponseEntity.noContent().build();
    }
}
