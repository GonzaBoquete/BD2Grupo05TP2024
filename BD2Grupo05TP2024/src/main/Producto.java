package main;

public class Producto {
    private int codigo;
    private String descripcion;
    private float precio;
    private String laboratorio;
    private String tipo;

    // Constructor
    public Producto(int codigo, String descripcion, float precio, String laboratorio, String tipo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.laboratorio = laboratorio;
        this.tipo = tipo;
    }

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return String.format("\n*Producto:\n" +
                "  Código: %d\n" +
                "  Descripción: %s\n" +
                "  Precio: %.2f\n" +
                "  Laboratorio: %s\n" +
                "  Tipo: %s\n\n",
                codigo, descripcion, precio, laboratorio, tipo);
    }
    
}