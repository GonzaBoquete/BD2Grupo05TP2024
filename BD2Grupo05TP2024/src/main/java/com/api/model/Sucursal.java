package com.api.model;

public class Sucursal {
	private int idSucursal;
	private String domicilio;
	private Empleado encargado;

	// Constructor
	public Sucursal(int idSucursal, String domicilio, Empleado encargado) {
		this.idSucursal = idSucursal;
		this.domicilio = domicilio;
		this.encargado = encargado;
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

	public Empleado getEncargado() {
		return encargado;
	}

	public void setEncargado(Empleado encargadoEmpleado) {
		this.encargado = encargadoEmpleado;
	}

	@Override
	public String toString() {
		String encargadoInfo = (encargado != null) ? encargado.getApellido() + ", " + encargado.getNombre()
				: "Ningún encargado asignado";
		return "Sucursal [idSucursal=" + idSucursal + ", domicilio=" + domicilio + ", encargado=" + encargadoInfo + "]";
	}

}
