package com.tp.onetoone.resource;

import com.tp.onetoone.model.Users;
import com.tp.onetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/users")
public class UsersResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/all")
    public List<Users> getAll() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/{name}")
    public List<Users> getUser(@PathVariable("name") String name) {
        return userRepository.findByName(name);
    }

    @GetMapping(value = "/id/{id}")
    public Users getId(@PathVariable("id") Users users) {
        return users;
    }

    @GetMapping(value = "/id/{id}/{name}")
    public Users getId(@PathVariable("id") Users users,
                             @PathVariable("name") String name) {
        users.setName(name);

        return userRepository.save(users);
    }
}