package main;


import java.util.List;

public class DetalleVenta {
    private List<Producto> productos;
    private int cantidad;
    private float precioUnidad;
    private float total;

    // Constructor
    public DetalleVenta(List<Producto> productos, int cantidad, float precioUnidad) {
        this.productos = productos;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        calcularTotal();
    }

    // Getters y Setters
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
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
        float totalProductos = 0.0f;
        for (Producto producto : productos) {
            totalProductos += producto.getPrecio() * cantidad;
        }
        this.total = totalProductos;
    }

	@Override
	public String toString() {
		return "" + productos + ", total=" + total + "]";
	}
    
 
    
}

    


