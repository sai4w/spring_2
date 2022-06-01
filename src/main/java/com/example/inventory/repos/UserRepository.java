package com.example.inventory.repos;

import java.util.List;

import com.example.inventory.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
      User findByUsername (String username);

}
