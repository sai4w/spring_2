package com.example.inventory.repos;

import com.example.inventory.entities.Type;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {

}
