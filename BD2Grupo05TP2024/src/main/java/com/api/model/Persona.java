package com.api.model;

public class Persona {
	private int DNI;
	private String apellido;
	private String nombre;
	private String domicilio;
	private String obraSocial;
	private String nroAfiliado;

	// Constructor
	public Persona(int DNI, String apellido, String nombre, String domicilio, String obraSocial, String nroAfiliado) {
		this.DNI = DNI;
		this.apellido = apellido;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.obraSocial = obraSocial;
		this.nroAfiliado = nroAfiliado;
	}

	// Getters y Setters
	public int getDNI() {
		return DNI;
	}

	public void setDNI(int DNI) {
		this.DNI = DNI;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}

	public String getNroAfiliado() {
		return nroAfiliado;
	}

	public void setNroAfiliado(String nroAfiliado) {
		this.nroAfiliado = nroAfiliado;
	}

	@Override
	public String toString() {
		return "Persona [DNI=" + DNI + ", apellido=" + apellido + ", nombre=" + nombre + ", domicilio=" + domicilio
				+ ", obraSocial=" + obraSocial + ", nroAfiliado=" + nroAfiliado + "]";
	}

}
