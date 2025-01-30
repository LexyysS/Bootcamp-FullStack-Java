package com.clases;

public class Aplicacion {

	public static void main(String[] args) {
		TiendaElectronica tienda = new TiendaElectronica();
		
		ComputadoraPortatil notebook = new ComputadoraPortatil("Macbook air M1",500000,4,"Apple","8GB","4003002");
		Televisor tv = new Televisor("Samsung TV C50VSUG",340000,2,55,"4K");
		
		tienda.agregarProducto(notebook);
		tienda.agregarProducto(tv);
		
		
		tienda.venderProducto(notebook);
		tienda.buscarProducto(notebook.getNombre());
		System.out.println("-------------------");
		
		tienda.venderProducto(tv);
		tienda.buscarProducto(tv.getNombre());
		System.out.println("-------------------");
		
		tienda.venderProducto(tv);
		tienda.venderProducto(tv);
		
		tienda.mostrarProductos();
		

	}

}
