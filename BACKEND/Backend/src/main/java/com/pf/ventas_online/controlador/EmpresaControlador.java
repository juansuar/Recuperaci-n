package com.pf.ventas_online.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pf.ventas_online.modelo.Empresa;
import com.pf.ventas_online.repositorio.ContactoRepositorio;
import com.pf.ventas_online.servicio.EmpresaServicio;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "http://localhost:3000")
public class EmpresaControlador {

    @Autowired
    private EmpresaServicio empresaServicio;

    @Autowired
    private ContactoRepositorio contactoRepositorio;

    @GetMapping
    public List<Empresa> obtenerEmpresas() {
        return empresaServicio.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Empresa empresaPorId(@PathVariable String id){
        return empresaServicio.empresaPorId(id);
    }

    @PostMapping
    public Empresa crearEmpresa(@RequestBody Empresa empresa) {
        return empresaServicio.guardarEmpresa(empresa);
    }

    @PutMapping("/{id}")
    public Empresa actualizarEmpresa(@PathVariable String id, @RequestBody Empresa empresa) {
        return empresaServicio.actualizarEmpresa(id, empresa);
    }

    @DeleteMapping("/{id}")
    public void eliminarEmpresa(@PathVariable String id) {
        contactoRepositorio.deleteByEmpresaId(id);
        empresaServicio.eliminarEmpresa(id);
    }
}
