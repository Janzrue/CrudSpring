package com.spring.app.controller;
import com.spring.app.models.User;
import com.spring.app.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/")
public class Controller {

    @Autowired
    private Service service;

    @GetMapping()
    public String index(){
        return service.index();
    }

    @GetMapping("users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("users/{id}")
    public Optional <User> getUserByID(@PathVariable("id") Long id) {
        return service.getUserByID(id);
    }

    @PostMapping("users")
    public String createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @PutMapping("users/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("users/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        return service.deleteUser(id);
    }

}
