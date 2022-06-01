package com.example.inventory.service;

import java.util.List;

import com.example.inventory.entities.Role;
import com.example.inventory.entities.User;

import org.springframework.data.domain.Page;


public interface UserService {
	
    List <User> findAll();
	
	User saveUser(User e);
	User updateUser(User e);
	void deleteUser(User e);
	void deleteUserById(Long id);
	User getUser(Long id);
	Page<User> getAllUsersParPage(int page, int size);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);


}
