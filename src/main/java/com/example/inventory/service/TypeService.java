package com.example.inventory.service;

import java.util.List;

import com.example.inventory.entities.Type;

import org.springframework.data.domain.Page;

public interface TypeService {
	List <Type> findAll();
	
	Type saveType(Type type);
	Type updateType(Type type);
	void deleteType(Type type);
	void deleteTypeById(Long id);
	Type getType(Long id);
	Page<Type> getAllTypesParPage(int page, int size);

}
