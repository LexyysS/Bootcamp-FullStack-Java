package com.alexis.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexis.modelos.Serie;
import com.alexis.modelos.Usuario;
import com.alexis.repositorios.RepositorioSeries;
import com.alexis.repositorios.RepositorioUsuarios;

@Service
public class ServicioSeries {
	
	@Autowired
	private RepositorioSeries repositorioSeries;
	
	@Autowired
	private RepositorioUsuarios repositorioUsuarios;
	
	public List<Serie> mostrarSeries(){
		return repositorioSeries.findAllByOrderByTituloAsc();
	}
	
	public Serie agregarSerie(Serie nuevaSerie) {
		return repositorioSeries.save(nuevaSerie);
	}
	
	public Serie buscarSerie(Long id) {
		return repositorioSeries.findById(id).orElse(null);
	}
	
	public void eliminarSerie(Long id) {
		repositorioSeries.deleteById(id);
	}
	
	public Usuario buscarUsuario(Long id) {
		return repositorioUsuarios.findById(id).orElse(null);
	}
	
	public void comprar(Long usuarioId, Long serieId) {
		Usuario usuario = buscarUsuario(usuarioId);
		Serie serie = buscarSerie(serieId);
		
		//Da error cuando es 0 la cantidad , ya que por la validacion de deber ser positivo 
		if(serie.getCantidad() > 0) {
			if(serie.getCantidad() == 1) {
				serie.setCantidad(1);
			}else {
				serie.setCantidad(serie.getCantidad() - 1);
			}
			
		}

		
		usuario.getMisCompras().add(serie);
		repositorioUsuarios.save(usuario);
		repositorioSeries.save(serie);
	}
	
	
	
	
	
}
