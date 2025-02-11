package com.alexis.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexis.modelos.Cancion;
import com.alexis.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {
	
	@Autowired
	private final RepositorioCanciones repositorioCanciones;
	
	public ServicioCanciones(RepositorioCanciones repositorioCanciones) {
		this.repositorioCanciones = repositorioCanciones;
	}
	
	public List<Cancion> obtenerTodasLasCanciones(){
		return this.repositorioCanciones.findAll();
	}
	
	public Cancion obtenerCancionPorId(Long id) {
		return this.repositorioCanciones.findById(id).orElse(null);
	}
	
	public Cancion agregarCancion(Cancion cancion) {
		return this.repositorioCanciones.save(cancion);
	}
}
