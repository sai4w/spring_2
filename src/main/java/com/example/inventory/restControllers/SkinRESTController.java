package com.example.inventory.restControllers;

import java.util.List;

import com.example.inventory.entities.Skin;
import com.example.inventory.service.SkinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SkinRESTController {
	@Autowired
	SkinService skinService;
	
	
		@RequestMapping(method=RequestMethod.GET)
		List<Skin>getAllSkins(){ 
			return skinService.getAllSkins();
		}
		
		@RequestMapping(value="/{id}",method = RequestMethod.GET)
		public Skin getSkinById(@PathVariable("id") Long id) 
		{ 
			return skinService.getSkin(id);
		}
		
		@RequestMapping(value="/recherche/{nameSkin}",method = RequestMethod.GET)
		public List<Skin> getSkinByNameContains(@PathVariable("nameSkin") String nameSkin) 
		{ 
			return skinService.findByNameSkinContains(nameSkin);
		}

		@RequestMapping(method = RequestMethod.POST)
		public Skin createSkin(@RequestBody Skin skin) {
		return skinService.saveSkin(skin);
		}
		
		
		@RequestMapping(method = RequestMethod.PUT)
		public Skin updateSkin(@RequestBody Skin skin) {
		return skinService.updateSkin(skin);
		}
		
		@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
		public void deleteSkin(@PathVariable("id") Long id)
		{
			skinService.deleteSkinById(id);
		}
		
		@RequestMapping(value="/type/{idType}",method = RequestMethod.GET)
		public List<Skin> getSkinsByTypeId(@PathVariable("idtype") Long idType) 
		{
		return skinService.findByTypeIdType(idType);
		}
}
