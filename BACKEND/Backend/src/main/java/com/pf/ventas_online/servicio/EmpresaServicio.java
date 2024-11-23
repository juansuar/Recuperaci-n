package com.pf.ventas_online.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pf.ventas_online.modelo.Empresa;
import com.pf.ventas_online.repositorio.EmpresaRepositorio;

import java.util.List;

@Service
public class EmpresaServicio {

    @Autowired
    private EmpresaRepositorio empresaRepositorio;

    public List<Empresa> obtenerTodas() {
        return empresaRepositorio.findAll();
    }

    public Empresa guardarEmpresa(Empresa empresa) {
        return empresaRepositorio.save(empresa);
    }

    public Empresa empresaPorId(String id) {
        Empresa empresaEncontrada = empresaRepositorio.findById(id).orElseThrow();
        return empresaEncontrada;

    }

    public Empresa actualizarEmpresa(String id, Empresa empresa) {
        Empresa empresaExistente = empresaRepositorio.findById(id).orElseThrow();
        empresaExistente.setNombre(empresa.getNombre());
        empresaExistente.setDireccion(empresa.getDireccion());
        empresaExistente.setTelefono(empresa.getTelefono());
        empresaExistente.setImagenUrl(empresa.getImagenUrl());
        return empresaRepositorio.save(empresaExistente);
    }

    public void eliminarEmpresa(String id) {
        empresaRepositorio.deleteById(id);
    }
}
