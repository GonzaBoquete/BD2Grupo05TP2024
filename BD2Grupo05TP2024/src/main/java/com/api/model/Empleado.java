package com.api.model;

public class Empleado extends Persona {
	private String CUIL;
	private boolean encargado;
	private Sucursal sucursal;

	// Constructor
	public Empleado(int DNI, String apellido, String nombre, String domicilio, String obraSocial, String nroAfiliado,
			String CUIL, boolean encargado, Sucursal sucursal) {
		super(DNI, apellido, nombre, domicilio, obraSocial, nroAfiliado);
		this.CUIL = CUIL;
		this.encargado = encargado;
		this.sucursal = sucursal;
	}

	// Getters y Setters
	public String getCUIL() {
		return CUIL;
	}

	public void setCUIL(String CUIL) {
		this.CUIL = CUIL;
	}

	public boolean isEncargado() {
		return encargado;
	}

	public void setEncargado(boolean encargado) {
		this.encargado = encargado;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	@Override
	public String toString() {
		return "Empleado{" + "DNI=" + getDNI() + ", Apellido='" + getApellido() + '\'' + ", Nombre='" + getNombre()
				+ '\'' + ", Domicilio='" + getDomicilio() + '\'' + ", ObraSocial='" + getObraSocial() + '\''
				+ ", NroAfiliado='" + getNroAfiliado() + '\'' + ", CUIL=" + CUIL + ", Encargado=" + encargado + '}';
	}
}
