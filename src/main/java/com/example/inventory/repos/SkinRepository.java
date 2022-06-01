package com.example.inventory.repos;

import java.util.List;

import com.example.inventory.entities.Skin;
import com.example.inventory.entities.Type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface SkinRepository extends JpaRepository<Skin, Long> {
	List<Skin> findByNameSkinContains(String nameSkin);
	List<Skin> findByTypeIdType(Long id);
	
}