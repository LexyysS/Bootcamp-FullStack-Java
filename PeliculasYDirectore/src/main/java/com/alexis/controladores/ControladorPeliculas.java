package com.alexis.controladores;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControladorPeliculas {
	private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();
	
	public ControladorPeliculas() {
		listaPeliculas.put("Winnie the Pooh", "Don Hall");	
		listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
		listaPeliculas.put("Tarzán", "Kevin Lima");		
		listaPeliculas.put("Mulán", "Barry Cook");
		listaPeliculas.put("Oliver", "Kevin Lima");	
		listaPeliculas.put("Big Hero 6", "Don Hall");	
	}
	
	
	@GetMapping("/peliculas")
	public String obtenerTodasLasPeliculas() {
		String lista = "";
		for(String i : listaPeliculas.keySet()) {
			lista = lista + "\n" + i ;
			
		}
		return lista;
		
	}
	
	@GetMapping("/peliculas/{nombre}")
	public String obtenerPeliculaPorNombre(@PathVariable("nombre") String nombre) {
		if(listaPeliculas.containsKey(nombre)) {
			return "Pelicula: " + nombre + " Director: " + listaPeliculas.get(nombre);
		}else {
			return "La película no se encuentra en nuestra lista";
		}
	}
	
	@GetMapping("/peliculas/director/{director}")
	public String obtenerPeliculasPorDirector(@PathVariable("director") String director) {
		StringBuilder lista = new StringBuilder("Listado de pelicula del Director "+ director +": \n");
		boolean encontradas = false;
		for(String i : listaPeliculas.keySet()) {
			if(listaPeliculas.get(i).toString().equals(director)) {
				lista.append("- ").append(i).append("\n");
				encontradas = true;
			}
			
		}
		
		if(!encontradas) {
			return "No contamos con películas con ese director en nuestra lista";
		}
		return lista.toString();
	}
}
