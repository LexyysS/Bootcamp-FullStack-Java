package com.alexis.modelos;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "series")
public class Serie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Por favor proporciona el titulo")
	@Size(min=3, message="El titulo debe tener al menos 5 caracteres")
	@Column(unique = true)
	private String titulo;
	
	@NotNull(message="Por favor proporciona el año")
	@Positive(message = "El año debe ser positivo")
	private int year;
	
	@NotBlank(message="Por favor proporciona la descripcion")
	@Size(min=10, message="La descripcion debe tener al menos 10 caracteres")
	private String descripcion;
	
	
	@NotBlank(message="Por favor proporciona una URL valida con la imagen")
    @Pattern(
        regexp = "(https?://.*\\.(?:png|jpg|jpeg))$",
        message = "La URL debe terminar con una extensión de imagen"
    )
	private String url;
	
	@NotNull(message="Por favor proporciona la cantidad de copias")
	@Positive(message = "La cantidad debe ser positivo")
	private int cantidad;
	
	
	@NotNull(message="Por favor proporciona un precio")
	private Long precio;
	
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private Usuario creador; 
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="series_compradas",
			joinColumns=@JoinColumn(name="serie_id"),
			inverseJoinColumns=@JoinColumn(name="usuario_id")
			)
	private List<Usuario> usuariosComprados;
	
	public Serie() {}

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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	public List<Usuario> getUsuariosComprados() {
		return usuariosComprados;
	}

	public void setUsuariosComprados(List<Usuario> usuariosComprados) {
		this.usuariosComprados = usuariosComprados;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
