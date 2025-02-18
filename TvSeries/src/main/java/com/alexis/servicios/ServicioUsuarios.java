package com.alexis.servicios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.alexis.modelos.LoginUsuario;
import com.alexis.modelos.Usuario;
import com.alexis.repositorios.RepositorioUsuarios;

@Service
public class ServicioUsuarios {
	
	@Autowired
	private RepositorioUsuarios repositorioUsuarios;
	
	public Usuario registrar(Usuario nuevoUsuario, BindingResult result) {
		
		String password = nuevoUsuario.getPassword();
		String confirmacion = nuevoUsuario.getConfirmacion();
		if(!password.equals(confirmacion)) {
			result.rejectValue("confirmacion", "Matches", "La Contraseña y Confirmacion debes ser iguales");
		}
		
		String email = nuevoUsuario.getEmail();
		Usuario existeUsuario = repositorioUsuarios.findByEmail(email);
		if(existeUsuario != null) {
			result.rejectValue("email", "Unique", "E-mail ya se encuentra registrado");
		}
		if(result.hasErrors()) {
			return null;
		} else {
			String passwordHasheado = BCrypt.hashpw(password, BCrypt.gensalt());
			nuevoUsuario.setPassword(passwordHasheado);
			return repositorioUsuarios.save(nuevoUsuario);
		}
	}
	
	public Usuario login(LoginUsuario inicioSesion, BindingResult result) {
		
		String email = inicioSesion.getEmailLogin();
		Usuario existeUsuario = repositorioUsuarios.findByEmail(email);
		if(existeUsuario == null) {
			
			result.rejectValue("emailLogin", "Unique", "E-mail no registrado");
		} else {
			
			if(! BCrypt.checkpw(inicioSesion.getPasswordLogin(), existeUsuario.getPassword())) {
				
				result.rejectValue("passwordLogin", "Matches", "Contraseña incorrecta");
			}
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			return existeUsuario;
		}
		
	}
	
	
	
	
	
}
