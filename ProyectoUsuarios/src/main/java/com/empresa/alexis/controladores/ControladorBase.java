package com.empresa.alexis.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorBase {
	@GetMapping("/")
	public String home() {
		return "<h1>Hola desde spring</h1>";
	}
	
	@GetMapping("/search")
	public String buscar(@RequestParam(value="q") String buscar) {
		return "<h1>Estas buscando: " + buscar + "</h1>";
	}
	
}
