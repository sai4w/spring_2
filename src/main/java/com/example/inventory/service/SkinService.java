package com.example.inventory.service;

import java.util.List;

import com.example.inventory.entities.Skin;
import com.example.inventory.entities.Type;

import org.springframework.data.domain.Page;

public interface SkinService {
	
	Skin saveSkin(Skin skin);
	Skin updateSkin(Skin skin);
	void deleteSkin(Skin skin);
	void deleteSkinById(Long id);
	Skin getSkin(Long id);
	List<Skin> getAllSkins();
	List<Skin> findByNameSkinContains(String nameSkin);
	List<Skin> findByTypeIdType(Long id);
	Page<Skin> getAllSkinsParPage(int page, int size);

}
