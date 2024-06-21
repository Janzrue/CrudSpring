package com.spring.app.controllers;

import com.spring.app.models.User;
import com.spring.app.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private Repository repositorio;


    @GetMapping()
    public String index(){
        return "CONECTADO";
    }

    @GetMapping("users")
    public List<User> getAllUsers(){
        return repositorio.findAll();
    }

    @GetMapping("users/{id}")
    public Optional<User> getUserByID(@PathVariable Long id){
        return repositorio.findById(id);
    }

    @PostMapping("users")
    public String createUser(@RequestBody User user){
        repositorio.save(user);
        return "Usuario creado";
    }

    @PutMapping("users/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user){
        User updatePersona = repositorio.findById(id).get();
        updatePersona.setName(user.getName());
        updatePersona.setPhone(user.getPhone());
        repositorio.save(updatePersona);
        return "Usuario editado";
    }

    @DeleteMapping("users/{id}")
    public String deleteUser(@PathVariable Long id){
        User deleteUser = repositorio.findById(id).get();
        repositorio.delete(deleteUser);
        return "Usuario eliminado";
    }
}
