package com.pf.ventas_online.servicio;

import com.pf.ventas_online.modelo.Articulo;
import com.pf.ventas_online.repositorio.ArticuloRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloServicio {

    @Autowired
    private ArticuloRepositorio articuloRepositorio;

    public List<Articulo> obtenerTodosLosArticulos() {
        return articuloRepositorio.findAll();
    }

    public Optional<Articulo> obtenerArticuloPorId(String id) {
        return articuloRepositorio.findById(id);
    }

    public Articulo agregarArticulo(Articulo articulo) {
        return articuloRepositorio.save(articulo);
    }

    public Articulo actualizarArticulo(String id, Articulo articulo) {
        articulo.setId(id);
        return articuloRepositorio.save(articulo);
    }

    public void eliminarArticulo(String id) {
        articuloRepositorio.deleteById(id);
    }
}
