package com.alexis.modelos;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "canciones")
public class Cancion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=5 ,max=30 , message="Introduce un titulo correctamente")
	private String titulo;
	
	@Size(min=3 ,max=20 , message="Introduce un artista correctamente")
	private String artista;
	
	@Size(min=3 ,max=20 , message="Introduce un album correctamente")
	private String album;
	
	@Size(min=3 ,max=20 , message="Introduce un genero correctamente")
	private String genero;
	
	@Size(min=3 ,max=20 , message="Introduce un idioma correctamente")
	private String idioma;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion", updatable = false, nullable = false)
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_actualizacion", nullable = false)
	private Date fechaActualizacion;
	   
	
	public Cancion() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getArtista() {
		return artista;
	}


	public void setArtista(String artista) {
		this.artista = artista;
	}


	public String getAlbum() {
		return album;
	}


	public void setAlbum(String album) {
		this.album = album;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getIdioma() {
		return idioma;
	}


	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	
	@PrePersist
	protected void onCreate() {
	    this.fechaCreacion = new Date();
	    this.fechaActualizacion = this.fechaCreacion;
	}
	@PreUpdate
	protected void onUpdate() {
	    this.fechaActualizacion = new Date();
	}	
	
	
}
