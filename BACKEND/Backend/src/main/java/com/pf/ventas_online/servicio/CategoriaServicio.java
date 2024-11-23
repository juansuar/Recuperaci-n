package com.pf.ventas_online.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pf.ventas_online.modelo.Categoria;
import com.pf.ventas_online.repositorio.CategoriaRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicio {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public List<Categoria> obtenerCategorias() {
        return categoriaRepositorio.findAll();
    }

    public Optional<Categoria> obtenerCategoriaPorId(String id) {
        return categoriaRepositorio.findById(id);
    }

    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepositorio.save(categoria);
    }

    public Categoria actualizarCategoria(String id, Categoria categoriaActualizada) {
        return categoriaRepositorio.findById(id).map(categoria -> {
            categoria.setNombre(categoriaActualizada.getNombre());
            categoria.setDescripcion(categoriaActualizada.getDescripcion());
            return categoriaRepositorio.save(categoria);
        }).orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }

    public void eliminarCategoria(String id) {
        categoriaRepositorio.deleteById(id);
    }
}
