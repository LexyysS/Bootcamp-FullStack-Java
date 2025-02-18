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

import com.alexis.modelos.Serie;
import com.alexis.modelos.Usuario;
import com.alexis.servicios.ServicioSeries;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorDashboard {
	
	@Autowired
	private ServicioSeries servicioSeries;
	
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession sesion, Model model) {
		if(sesion.getAttribute("usuarioSesion") == null) {
			return "redirect:/";
		}
		
		List<Serie> series = servicioSeries.mostrarSeries();
		model.addAttribute("series",series);
		
		Usuario usuarioSesion = (Usuario)sesion.getAttribute("usuarioSesion");
		Usuario usuario = servicioSeries.buscarUsuario(usuarioSesion.getId());
		model.addAttribute("usuario",usuario);
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/agregarSerie")
	public String agregarSerie(HttpSession sesion, @ModelAttribute("serie") Serie serie) {
		if(sesion.getAttribute("usuarioSesion") == null) {
			return "redirect:/";
		}
		
		return "agregarSerie.jsp";
	}
	
	
	@PostMapping("/guardarSerie")
	public String guardarSerie(@Valid @ModelAttribute("serie") Serie serie, BindingResult validacion, HttpSession sesion ){
		if(sesion.getAttribute("usuarioSesion") == null) {
			return "redirect:/";
		}
		
		if(validacion.hasErrors()) {
			return "agregarSerie.jsp";
		}
		else {
			servicioSeries.agregarSerie(serie);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/mostrar/{id}")
	public String mostrar(@PathVariable("id") Long id, HttpSession sesion, Model model) {
		if(sesion.getAttribute("usuarioSesion") == null) {
			return "redirect:/";
		}
		
		Serie serie = servicioSeries.buscarSerie(id);
		model.addAttribute("serie",serie);
		
		return "detalleSerie.jsp";
	}
	
	@GetMapping("/editar/{id}")
	public String editarSesion(@PathVariable("id") Long id, @ModelAttribute("serie") Serie serie, Model model
			, HttpSession sesion) {
		if(sesion.getAttribute("usuarioSesion") == null) {
			return "redirect:/";
		}
		
		Serie editarSerie = servicioSeries.buscarSerie(id);
		
		Usuario usuarioSesion = (Usuario)sesion.getAttribute("usuarioSesion");
		if(usuarioSesion.getId() != editarSerie.getCreador().getId()) {
			return "redirect:/dashboard";
		}
		
		model.addAttribute("serie",editarSerie);
		return "editarSerie.jsp";
	}
	
	@PutMapping("/actualizar/{id}")
	public String actualizar(@Valid @ModelAttribute("serie") Serie nuevaSerie, BindingResult validacion, HttpSession sesion, @PathVariable("id") Long id  ){
		if(sesion.getAttribute("usuarioSesion") == null) {
			return "redirect:/";
		}
		
		if(validacion.hasErrors()) {
			return "editarSerie.jsp";
		}
		else {
			nuevaSerie.setId(id);
			servicioSeries.agregarSerie(nuevaSerie);
			return "redirect:/dashboard";
		}
	}
	
	
	@DeleteMapping("/eliminarSerie/{id}")
	public String eliminarSerie(@PathVariable("id")Long id, HttpSession sesion) {
		if(sesion.getAttribute("usuarioSesion") == null) {
			return "redirect:/";
		}
		servicioSeries.eliminarSerie(id);
		return "redirect:/dashboard";
	}
	

	@GetMapping("/compras")
	public String compras(HttpSession session,Model model) {
		
		if(session.getAttribute("usuarioSesion") == null){
			return "redirect:/";
		}
		
		Usuario usuarioSesion = (Usuario)session.getAttribute("usuarioSesion");
		Usuario usuario = servicioSeries.buscarUsuario(usuarioSesion.getId());
		model.addAttribute("usuario", usuario);
		
		return "compras.jsp";
		
	}
	
	@GetMapping("/comprar/{usuarioId}/{serieId}")
	public String comprarSerie(@PathVariable("usuarioId") Long usuarioId,@PathVariable("serieId") Long serieId,HttpSession session) {
		
		if(session.getAttribute("usuarioSesion") == null){
			return "redirect:/";
		}
		
		servicioSeries.comprar(usuarioId, serieId);
		
		return "redirect:/compras";
	}
	
}
