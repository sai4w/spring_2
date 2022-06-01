package com.example.inventory.controllers;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import com.example.inventory.entities.Skin;
import com.example.inventory.entities.Type;
import com.example.inventory.service.TypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TypeController {
	
	@Autowired
	TypeService typeService;
	
	
	@RequestMapping("/create-type")
	public String showCreate(ModelMap modelMap) {
		Type type = new Type();
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("type", type);
		return "formType";
	}
	
	
	@RequestMapping("/list-types")
	public String listeSpecilates(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Type> types = typeService.getAllTypesParPage(page, size);
			
		modelMap.addAttribute("types", types);
		modelMap.addAttribute("pages", new int[types.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeTypes";
	}
	
	
	@RequestMapping("/saveType")
	public String saveType(@Valid Type type,
			 BindingResult bindingResult) {
		if (bindingResult.hasErrors()) return "formType";
	 typeService.saveType(type);
	 return "redirect:/list-types";
	}
	
	@RequestMapping("/delete-type")
	public String supprimerType(@RequestParam("id") Long id, ModelMap modelMap,

		@RequestParam(name = "page", defaultValue = "0") int page,
		@RequestParam(name = "size", defaultValue = "2") int size) {

		typeService.deleteTypeById(id);
		Page<Type> types = typeService.getAllTypesParPage(page,
				size);
		modelMap.addAttribute("types", types);
		modelMap.addAttribute("pages", new int[types.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeTypes";
	}
	
	
	@RequestMapping("/update-type")
	public String editertype(@RequestParam("id") Long id, ModelMap modelMap) {
		
		Type type = typeService.getType(id);
		modelMap.addAttribute("type", type);
		modelMap.addAttribute("mode", "edit");
		return "formType";
	}

	@RequestMapping("/updateType")
	public String updateType(@ModelAttribute("type") Type type, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		typeService.updateType(type);
		List<Type> types = typeService.findAll();
		modelMap.addAttribute("types", types);
		return "listeTypes";
	}

}
