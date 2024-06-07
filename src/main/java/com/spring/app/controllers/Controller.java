package com.spring.app.controllers;

import com.spring.app.models.Persona;
import com.spring.app.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private Repository repositorio;


    @GetMapping()
    public String index(){
        return "CONECTADO";
    }

    @GetMapping("usuarios")
    public List<Persona> getPersonas(){
        return repositorio.findAll();
    }

    @PostMapping("usuarios")
    public String post(@RequestBody Persona persona){
        repositorio.save(persona);
        return "Usuario Creado";
    }

    @PutMapping("usuarios/{id}")
    public String update(@PathVariable Long id, @RequestBody Persona persona){
        Persona updatePersona = repositorio.findById(id).get();
        updatePersona.setNombre(persona.getNombre());
        updatePersona.setTelefono(persona.getTelefono());
        repositorio.save(updatePersona);
        return "Usuario Editado";
    }

    @DeleteMapping("usuarios/{id}")
    public String delete(@PathVariable Long id){
        Persona deletePersona = repositorio.findById(id).get();
        repositorio.delete(deletePersona);
        return "Usuario Eliminado";
    }
}
