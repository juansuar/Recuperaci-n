package com.pf.ventas_online.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pf.ventas_online.modelo.Contacto;
import com.pf.ventas_online.repositorio.ContactoRepositorio;

import java.util.List;

@RestController
@RequestMapping("/api/contactos")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactoControlador {

    @Autowired
    private ContactoRepositorio contactoRepositorio;

    @PostMapping("/empresa/{empresaId}")
    public Contacto crearContacto(@PathVariable String empresaId, @RequestBody Contacto contacto) {
        contacto.setEmpresaId(empresaId);
        return contactoRepositorio.save(contacto);
    }

    @GetMapping("/empresa/{empresaId}")
    public List<Contacto> obtenerContactosPorEmpresa(@PathVariable String empresaId) {
        return contactoRepositorio.findByEmpresaId(empresaId);
    }

    @PutMapping("/{id}")
    public Contacto actualizarContacto(@PathVariable String id, @RequestBody Contacto contactoActualizado) {
        Contacto contacto = contactoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Contacto no encontrado"));
        contacto.setNombre(contactoActualizado.getNombre());
        contacto.setTelefono(contactoActualizado.getTelefono());
        contacto.setEmail(contactoActualizado.getEmail());
        return contactoRepositorio.save(contacto);
    }

    @DeleteMapping("/{id}")
    public void eliminarContacto(@PathVariable String id) {
        contactoRepositorio.deleteById(id);
    }

    @GetMapping
    public List<Contacto> obtenerTodosLosContactos() {
        return contactoRepositorio.findAll();
    }
}
