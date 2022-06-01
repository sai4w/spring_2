package com.example.inventory.service;

import java.util.List;

import com.example.inventory.entities.Role;

public interface RoleService {

	List <Role> findAll();
	Role findByRole(String role);



}
