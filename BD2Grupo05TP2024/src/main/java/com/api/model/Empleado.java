package com.api.model;

public class Empleado extends Persona {
    private String CUIL;
    private boolean encargado;

    // Constructor
    public Empleado(int DNI, String apellido, String nombre, String domicilio, String obraSocial, String nroAfiliado, String CUIL, boolean encargado) {
        super(DNI, apellido, nombre, domicilio, obraSocial, nroAfiliado);
        this.CUIL = CUIL;
        this.encargado = encargado;
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

    @Override
    public String toString() {
        return "Empleado{" +
                "DNI=" + getDNI() +
                ", Apellido='" + getApellido() + '\'' +
                ", Nombre='" + getNombre() + '\'' +
                ", Domicilio='" + getDomicilio() + '\'' +
                ", ObraSocial='" + getObraSocial() + '\'' +
                ", NroAfiliado='" + getNroAfiliado() + '\'' +
                ", CUIL=" + CUIL +
                ", Encargado=" + encargado +
                '}';
    }
}
