package com.alexis.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alexis.modelos.LoginUsuario;
import com.alexis.modelos.Usuario;
import com.alexis.servicios.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {
	
	@Autowired
	private ServicioUsuarios servicioUsuarios;
	
	@GetMapping("/")
	public String index(@ModelAttribute("nuevoUsuario") Usuario nuevoUsuario) {
		return "index.jsp";
	}
	
	@PostMapping("/registro")
	public String registro(@Valid @ModelAttribute("nuevoUsuario") Usuario nuevoUsuario, 
			BindingResult validacion , HttpSession sesion) {
		
		servicioUsuarios.registrar(nuevoUsuario, validacion);
		if(validacion.hasErrors()) {
			return "index.jsp";
			
		}
		else {
			sesion.setAttribute("usuarioSesion", nuevoUsuario);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/login")
	public String login(@ModelAttribute("loginUsuario") LoginUsuario loginUsuario) {
		return "login.jsp";
	}
	
	@PostMapping("/iniciarSesion")
	public String iniciarSesion(@Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario,
			BindingResult validacion, HttpSession sesion) {
		
		Usuario usuario = servicioUsuarios.login(loginUsuario, validacion);
		
		if(validacion.hasErrors()) {
			return "login.jsp";
		} else {
			sesion.setAttribute("usuarioSesion", usuario);
			return "redirect:/dashboard";
		}
		
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/";
	}
	

}
