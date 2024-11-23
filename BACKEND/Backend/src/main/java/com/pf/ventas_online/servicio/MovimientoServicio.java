package com.pf.ventas_online.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pf.ventas_online.modelo.Movimiento;
import com.pf.ventas_online.repositorio.MovimientoRepositorio;

import java.util.List;

@Service
public class MovimientoServicio {

    @Autowired
    private MovimientoRepositorio movimientoRepositorio;

    public List<Movimiento> obtenerTodosLosMovimientos() {
        return movimientoRepositorio.findAll();
    }

    public Movimiento agregarMovimiento(Movimiento movimiento) {
        return movimientoRepositorio.save(movimiento);
    }

    public void eliminarMovimiento(String id) {
        movimientoRepositorio.deleteById(id);
    }
}
