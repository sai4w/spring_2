package com.example.inventory.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.example.inventory.entities.Skin;
import com.example.inventory.entities.Type;
import com.example.inventory.service.SkinService;
import com.example.inventory.service.TypeService;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SkinController {

	@Autowired
	SkinService skinService;

	@Autowired
	TypeService typeService;
	
	@RequestMapping("/create-skin")
	public String showCreate(ModelMap modelMap) {
		List<Type> types = typeService.findAll();
		Skin skin = new Skin();
		Type type = new Type();
		type = types.get(0);
		skin.setType(type);
		
		modelMap.addAttribute("skin", skin);
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("types", types);

		return "formSkin";
	}
	
	
	@RequestMapping("/search-by-name")
	public String doSearchSkinByName(@ModelAttribute("SkinSearchFormData")Skin formData,Model model, @RequestParam("nameSkin") String nameSkin) {
		List<Skin> skins = skinService.findByNameSkinContains(nameSkin);
		model.addAttribute("skins", skins);
		return "inventory";
	}
	
	@RequestMapping("/search-by-type")
	public String doSearchSkinByType(@ModelAttribute("SkinSearchFormData")Skin formData,Model modelMap, @RequestParam("id") Long id) {
		List<Type> types = typeService.findAll();
		modelMap.addAttribute("types", types);
		
		List<Skin> skins = skinService.findByTypeIdType(id);
		modelMap.addAttribute("skins",skins);

		return "inventory";
	}


	@RequestMapping("/saveSkin")
	public String saveSkin(@Valid Skin skin, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) return "formSkin";
	 	skinService.saveSkin(skin);
	 return "redirect:/list-skins";
	}

	@RequestMapping("/list-skins")
	public String listskins(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Skin> skins = skinService.getAllSkinsParPage(page, size);
		
		List<Type> types = typeService.findAll();
		modelMap.addAttribute("types", types);
		
		modelMap.addAttribute("skins", skins);
		modelMap.addAttribute("pages", new int[skins.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "inventory";
	}

	@RequestMapping("/supprimer-skin")
	public String supprimerSkin(@RequestParam("id") Long id, ModelMap modelMap,

		@RequestParam(name = "page", defaultValue = "0") int page,
		@RequestParam(name = "size", defaultValue = "2") int size) {

		skinService.deleteSkinById(id);
		Page<Skin> skins = skinService.getAllSkinsParPage(page, size);
		modelMap.addAttribute("skins", skins);
		modelMap.addAttribute("pages", new int[skins.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "inventory";
	}

	@RequestMapping("/modifier-skin")
	public String editerSkin(@RequestParam("id") Long id, ModelMap modelMap) {
		
		Skin skin = skinService.getSkin(id);
		List<Type> types = typeService.findAll();
		modelMap.addAttribute("skin", skin);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("types", types);
		return "formSkin";
	}

	@RequestMapping("/updateSkin")
	public String updateSkin(@ModelAttribute("skin") Skin skin, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateEmbauche = dateformat.parse(String.valueOf(date));
		skin.setDateSkin(dateEmbauche);

		skinService.updateSkin(skin);
		List<Skin> skins = skinService.getAllSkins();
		modelMap.addAttribute("skins", skins);
		return "inventory";
	}

}
