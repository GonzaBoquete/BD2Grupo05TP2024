package com.api.model;

public class Sucursal {
	private int idSucursal;
	private String domicilio;

	// Constructor
	public Sucursal(int idSucursal, String domicilio) {
		this.idSucursal = idSucursal;
		this.domicilio = domicilio;
	}

	// Getters y Setters
	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	@Override
	public String toString() {
		return "Sucursal [idSucursal=" + idSucursal + ", domicilio=" + domicilio + "]";
	}

}
