package com.api.model;

public class DetalleVenta {
	private Producto producto;
	private int cantidad;
	private float precioUnidad;
	private float total;

	// Constructor
	public DetalleVenta(Producto producto, int cantidad, float precioUnidad) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioUnidad = precioUnidad;
		calcularTotal();
	}

	// Getters y Setters
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
		calcularTotal();
	}

	public float getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(float precioUnidad) {
		this.precioUnidad = precioUnidad;
		calcularTotal();
	}

	public float getTotal() {
		return total;
	}

	// Método privado para calcular el total
	private void calcularTotal() {
		this.total = this.precioUnidad * this.cantidad;
	}

	@Override
	public String toString() {
		return "" + producto + ", total=" + total + "]";
	}

}
