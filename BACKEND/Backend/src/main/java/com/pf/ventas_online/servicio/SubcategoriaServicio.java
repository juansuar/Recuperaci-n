package com.pf.ventas_online.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pf.ventas_online.modelo.Subcategoria;
import com.pf.ventas_online.repositorio.SubcategoriaRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class SubcategoriaServicio {

    @Autowired
    private SubcategoriaRepositorio subcategoriaRepositorio;

    public List<Subcategoria> obtenerSubcategoriasPorCategoria(String categoriaId) {
        return subcategoriaRepositorio.findByCategoriaId(categoriaId);
    }

    public List<Subcategoria> obtenerSubcategorias() {
        return subcategoriaRepositorio.findAll();
    }

    public Optional<Subcategoria> obtenerSubcategoriaPorId(String id) {
        return subcategoriaRepositorio.findById(id);
    }

    public Subcategoria crearSubcategoria(Subcategoria subcategoria) {
        return subcategoriaRepositorio.save(subcategoria);
    }

    public Subcategoria actualizarSubcategoria(String id, Subcategoria subcategoriaActualizada) {
        subcategoriaActualizada.setId(id);
        return subcategoriaRepositorio.save(subcategoriaActualizada);
    }

    public void eliminarSubcategoria(String id) {
        subcategoriaRepositorio.deleteById(id);
    }
}
