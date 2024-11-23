package com.pf.ventas_online.controlador;

import com.pf.ventas_online.modelo.Categoria;
import com.pf.ventas_online.servicio.CategoriaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoriaControlador {

    @Autowired
    private CategoriaServicio categoriaServicio;

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaServicio.obtenerCategorias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerCategoria(@PathVariable String id) {
        Optional<Categoria> categoria = categoriaServicio.obtenerCategoriaPorId(id);
        return categoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return categoriaServicio.crearCategoria(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable String id, @RequestBody Categoria categoria) {
        try {
            return ResponseEntity.ok(categoriaServicio.actualizarCategoria(id, categoria));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable String id) {
        categoriaServicio.eliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
