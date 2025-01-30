package com.clases;

public class ProductoElectrodomestico {
	private String nombre;
	private int precio;
	private int cantidadDisponible;
	
	
	public ProductoElectrodomestico(String nombre, int precio, int cantidadDisponible) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadDisponible = cantidadDisponible;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public int getCantidadDisponible() {
		return cantidadDisponible;
	}


	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}
	
	public void mostrarInformacion() {
		System.out.println("Nombre: " + this.nombre + "\nPrecio: "+ this.precio + "\nCantidad disponible: " + this.cantidadDisponible);
	}
	

}
