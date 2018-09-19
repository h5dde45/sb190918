package com.tp.mysqljpa.repository;

import com.tp.mysqljpa.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
