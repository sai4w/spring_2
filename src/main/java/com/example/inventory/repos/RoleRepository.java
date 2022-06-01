package com.example.inventory.repos;


import java.util.List;
import java.util.Optional;

import com.example.inventory.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository  extends JpaRepository<Role, Long> {
	
	Role findByRole(String role);
	Optional<Role> findById(Long id);
	



}
