package com.empresa.alexis.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorUsuarios {
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("titulo", "Estamos integrando Model model");
		
		String usuarios[] = {"Alexis", "Cynthia", "Pablo", "Juan", "Pedro" , "Diego"};
		model.addAttribute("users", usuarios);
		
		return "index.jsp";
	}
}
