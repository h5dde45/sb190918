package com.tp.restjpa.repository;

import com.tp.restjpa.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<Users, Long> {

    List<Users> findByName(String name);

}
