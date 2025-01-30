package com.clases;
import java.util.ArrayList;

public class TiendaElectronica {
	private ArrayList<ProductoElectrodomestico> listaDeProductos = new ArrayList<>();
	
	public void agregarProducto(ProductoElectrodomestico producto) {
		listaDeProductos.add(producto);
	}
	
	public void mostrarProductos() {
		for(ProductoElectrodomestico producto : listaDeProductos) {
			producto.mostrarInformacion();
			System.out.println("-------------------");
		}
	}
	
	public void buscarProducto(String nombre) {
		for(ProductoElectrodomestico producto: listaDeProductos) {
			if(producto.getNombre().equals(nombre)) {
				producto.mostrarInformacion();
			}
		}
	}
	
	public void venderProducto(ProductoElectrodomestico producto) {
		if(producto.getCantidadDisponible() > 0) {
			producto.setCantidadDisponible(producto.getCantidadDisponible() - 1);
		}else {
			System.out.println("Producto agotado\n");
		}
	}
	
}
