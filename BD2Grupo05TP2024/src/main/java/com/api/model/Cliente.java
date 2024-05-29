package com.api.model;

public class Cliente extends Persona {
	// Constructor
	public Cliente(int DNI, String apellido, String nombre, String domicilio, String obraSocial, String nroAfiliado) {
		super(DNI, apellido, nombre, domicilio, obraSocial, nroAfiliado);
	}

	@Override
	public String toString() {
		return "Cliente {" + "DNI=" + getDNI() + ", Apellido='" + getApellido() + '\'' + ", Nombre='" + getNombre()
				+ '\'' + ", Domicilio='" + getDomicilio() + '\'' + ", ObraSocial='" + getObraSocial() + '\''
				+ ", NroAfiliado='" + getNroAfiliado() + '\'' + '}';
	}

}