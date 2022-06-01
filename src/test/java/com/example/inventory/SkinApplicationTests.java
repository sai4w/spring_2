package com.example.inventory;

import java.util.Date;
import java.util.List;

import com.example.inventory.entities.Skin;
import com.example.inventory.entities.Type;
import com.example.inventory.repos.SkinRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SkinApplicationTests {

	@Autowired
	private SkinRepository skinRepository;

	@Test
	public void testfindByNameSkin() {
		List<Skin> skins = skinRepository.findAll();
		for (Skin skin : skins)
			System.out.println(skin);
	}

}
