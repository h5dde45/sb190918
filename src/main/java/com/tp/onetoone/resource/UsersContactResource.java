package com.tp.onetoone.resource;


import com.tp.onetoone.model.Users;
import com.tp.onetoone.model.UsersContact;
import com.tp.onetoone.repository.UsersContactRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/rest/userscontact")
@RestController
public class UsersContactResource {

    private UsersContactRepository usersContactRepository;

    public UsersContactResource(UsersContactRepository usersContactRepository) {
        this.usersContactRepository = usersContactRepository;
    }

    @GetMapping(value = "/all")
    public List<UsersContact> getUsersContact() {
        return usersContactRepository.findAll();
    }

    @GetMapping(value = "/update/{name}")
    public List<UsersContact> update(@PathVariable final String name) {

        UsersContact usersContact = new UsersContact();

        Users users = new Users();
        users.setTeamName("Development");
        users.setSalary(10000);
        users.setName(name);

        usersContact.setPhoneNo(11111)
                .setUsers(users);

        usersContactRepository.save(usersContact);

        return usersContactRepository.findAll();

    }

}
