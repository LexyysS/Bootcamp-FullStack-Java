package com.alexis.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.alexis.modelos.Cancion;
import com.alexis.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
	
	@Autowired 
	private final ServicioCanciones servicioCanciones;
	
	public ControladorCanciones(ServicioCanciones servicioCanciones) {
		this.servicioCanciones = servicioCanciones;
	}
	
	@GetMapping("/canciones")
	public String desplegarCanciones(Model model) {
		List<Cancion> listaCanciones = this.servicioCanciones.obtenerTodasLasCanciones();
		model.addAttribute("listaCanciones",listaCanciones);
		return "canciones.jsp";
	}
	
	@GetMapping("/canciones/detalle/{idCancion}")
	public String desplegarDetalleCancion(@PathVariable("idCancion") Long idCancion, Model model) {
		Cancion cancion = this.servicioCanciones.obtenerCancionPorId(idCancion);
		model.addAttribute(cancion);
		return "detalleCancion.jsp";
	}
	
	@GetMapping("/canciones/formulario/agregar")
	public String formularioAgregarCancion(@ModelAttribute("cancion") Cancion cancion) {
		return "agregarCancion.jsp";
	}
	
	@PostMapping("/canciones/procesa/agregar")
	public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult validacion)  {
		if(validacion.hasErrors()) {
			return "agregarCancion.jsp";
		}
		
		this.servicioCanciones.agregarCancion(cancion);
		
		return "redirect:/canciones";
		
	}
	
	@GetMapping("/canciones/formulario/editar/{idCancion}")
	public String formularioEditarCancion(@ModelAttribute("cancion")Cancion cancion, 
			@PathVariable("idCancion")Long id, Model model) {
		
		Cancion nuevacancion = this.servicioCanciones.obtenerCancionPorId(id);
		model.addAttribute(nuevacancion);
		return "editarCancion.jsp";
	}
	
	@PutMapping("/canciones/procesa/editar/{idCancion}")
	public String procesarEditarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
			BindingResult validaciones, @PathVariable("idCancion") Long id ) {
		
		if(validaciones.hasErrors()) {
			return "editarCancion.jsp";
		}
		cancion.setId(id);
		
		this.servicioCanciones.actualizaCancion(cancion);
		
		return "redirect:/canciones";
		
	}
	
	@DeleteMapping("/canciones/eliminar/{idCancion}")
	public String procesarEliminarCancion(@PathVariable("idCancion") Long id) {
		this.servicioCanciones.eliminaCancion(id);
		return "redirect:/canciones";
	}
}