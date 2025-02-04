package com.clases;

public class ComputadoraPortatil extends ProductoElectrodomestico {
	private String marca;
	private String memoriaRAM;
	private String numeroSerie;
	
	public ComputadoraPortatil(String nombre, int precio, int cantidadDisponible, String marca, String memoriaRAM, String numeroSerie) {
		super(nombre, precio, cantidadDisponible);
		this.marca = marca;
		this.memoriaRAM = memoriaRAM;
		this.numeroSerie = numeroSerie;
		
	}
	
	@Override
	public void mostrarInformacion() {
		super.mostrarInformacion();
		System.out.println("Marca: " + this.marca + "\nMemoria Ram: " + this.memoriaRAM + "\nNumero de serie: " + this.numeroSerie);
	}
}
