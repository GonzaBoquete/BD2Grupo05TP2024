package main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear cliente
        Cliente cliente = new Cliente(12345678, "González", "María", "Calle 123", "OSDE", "123456");

        // Crear sucursal sin encargado inicialmente
        Sucursal sucursal = new Sucursal(1, "Dirección de la sucursal", null);
        
        // Crear encargado
        Empleado encargado = new Empleado(98765432, "López", "Pedro", "Av. Secundaria", "Otra", "987654", 987654321, true, sucursal);
        
        // Asignar encargado a la sucursal
        sucursal.setEncargado(encargado);

        // Crear lista de productos
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Aspirinas", 10.0f, "Laboratorio X", "Farmacia"));
        productos.add(new Producto(2, "Paracetamol", 8.0f, "Laboratorio Z", "Farmacia"));
        productos.add(new Producto(3, "Pastilla de Carbon", 12.0f, "Pharma", "Farmacia"));
        productos.add(new Producto(4, "Perfume para adulto", 12.0f, "Laboratorio Y", "Perfumeria"));
        
        
        // Crear el detalle de venta con la lista de productos
        DetalleVenta detalleVenta = new DetalleVenta(productos, 2, 10.5f);
        
        // Crear la venta
        Venta venta = new Venta(1001, LocalDateTime.now(), 21.0f, "Efectivo", cliente, null, encargado, detalleVenta);
        
        // Mostrar información de la venta
        System.out.println(venta);
    }
}

