package com.tp.restjpa.controller;

import com.tp.restjpa.model.Users;
import com.tp.restjpa.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @GetMapping(value = "/all")
    public List<Users> findAll() {
        return userJpaRepository.findAll();
    }

    @GetMapping(value = "/{name}")
    public List<Users> findByName(@PathVariable final String name) {
        return userJpaRepository.findByName(name);
    }

    @PostMapping(value = "/load")
    public Users loud(@RequestBody final Users users){
        return userJpaRepository.save(users);
    }
}
