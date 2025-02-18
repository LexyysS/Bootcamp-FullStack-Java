package com.alexis.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alexis.modelos.Serie;

@Repository
public interface RepositorioSeries extends CrudRepository<Serie, Long>{
	List<Serie> findAll();
	List<Serie> findAllByOrderByTituloAsc();
	
	
}
