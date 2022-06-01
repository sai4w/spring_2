package com.example.inventory.service;

import java.util.List;

import com.example.inventory.entities.Skin;
import com.example.inventory.entities.Type;
import com.example.inventory.repos.SkinRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class SkinServiceImpl implements SkinService{

	@Autowired
	SkinRepository skinRepository;
	
	@Override
	public Skin saveSkin(Skin skin) {
	
		return skinRepository.save(skin);
	}

	@Override
	public Skin updateSkin(Skin skin) {
		return skinRepository.save(skin);
	}

	@Override
	public void deleteSkin(Skin skin) {
		skinRepository.delete(skin);
	}

	@Override
	public void deleteSkinById(Long id) {
		skinRepository.deleteById(id);
	}

	@Override
	public Skin getSkin(Long id) {
		return skinRepository.findById(id).get();
	}

	@Override
	public List<Skin> getAllSkins() {
		return skinRepository.findAll();
	}

	

	@Override
	public List<Skin> findByNameSkinContains(String nom) {
		return skinRepository.findByNameSkinContains(nom);
	}

	

	



	@Override
	public List<Skin> findByTypeIdType(Long id) {
		return skinRepository.findByTypeIdType(id);
	}

	
	
	@Override
	public Page<Skin> getAllSkinsParPage(int page, int size) {
	return skinRepository.findAll(PageRequest.of(page, size));
	}

}
