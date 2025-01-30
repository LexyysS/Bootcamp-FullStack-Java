package com.clases;

public class Televisor extends ProductoElectrodomestico {
	private float tamanoPantalla;
	private String resolucion;
	
	public Televisor(String nombre, int precio, int cantidadDisponible , float tamanoPantalla, String resolucion) {
		super(nombre, precio, cantidadDisponible);
		this.tamanoPantalla = tamanoPantalla;
		this.resolucion = resolucion;
		
	}
	
	@Override
	public void mostrarInformacion() {
		super.mostrarInformacion();
		System.out.println("Tamaño de pantalla: " + this.tamanoPantalla + "\nResolucion: " + this.resolucion );
	}
	
	
}
