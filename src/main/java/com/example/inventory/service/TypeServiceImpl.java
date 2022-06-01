package com.example.inventory.service;

import java.util.List;

import com.example.inventory.entities.Type;
import com.example.inventory.repos.TypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {
	
	@Autowired
	private TypeRepository typeRepository;

	@Override
	public List<Type> findAll() {
		return typeRepository.findAll();
	}

	@Override
	public Type saveType(Type type) {
		return typeRepository.save(type) ;
	}

	@Override
	public Type updateType(Type type) {
		return typeRepository.save(type);
	}

	@Override
	public void deleteType(Type type) {
		typeRepository.delete(type);		
	}

	@Override
	public void deleteTypeById(Long id) {
		typeRepository.deleteById(id);		
	}

	@Override
	public Type getType(Long id) {
		return typeRepository.findById(id).get();
	}

	

	@Override
	public Page<Type> getAllTypesParPage(int page, int size) {
		return typeRepository.findAll(PageRequest.of(page, size));
	}

}
