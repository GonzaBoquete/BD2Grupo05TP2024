package com.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.api.dao.ClienteDAO;
import com.api.dao.EmpleadoDAO;
import com.api.dao.ProductoDAO;
import com.api.dao.SucursalDAO;
import com.api.dao.VentaDAO;
import com.api.model.Cliente;
import com.api.model.DetalleVenta;
import com.api.model.Empleado;
import com.api.model.Producto;
import com.api.model.Sucursal;
import com.api.model.Venta;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class AltaClases {

	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = mongoClient.getDatabase("BD2Grupo05TP2024");
		ClienteDAO clienteDAO = new ClienteDAO(database);
		EmpleadoDAO empleadoDAO = new EmpleadoDAO(database);
		SucursalDAO sucursalDAO = new SucursalDAO(database);
		ProductoDAO productoDAO = new ProductoDAO(database);
		VentaDAO ventaDAO = new VentaDAO(database);

		// Crear sucursales
		Sucursal sucursal1 = new Sucursal(1, "Calle 100");
		sucursalDAO.insertarSucursal(sucursal1);
		Sucursal sucursal2 = new Sucursal(2, "Calle 200");
		sucursalDAO.insertarSucursal(sucursal2);
		Sucursal sucursal3 = new Sucursal(3, "Calle 300");
		sucursalDAO.insertarSucursal(sucursal3);

		// Crear encargados y guardar
		Empleado encargado1 = new Empleado(98765432, "López", "Pedro", "Av. Secundaria 1", "OSDE", "123456",
				"20123456789", true, sucursal1);
		empleadoDAO.insertarEmpleado(encargado1);
		Empleado encargado2 = new Empleado(87654321, "Martínez", "Ana", "Av. Secundaria 2", "SWISS", "234567",
				"30123456789", true, sucursal2);
		empleadoDAO.insertarEmpleado(encargado2);
		Empleado encargado3 = new Empleado(76543210, "García", "Juan", "Av. Secundaria 3", "ACCORD", "345678",
				"40123456789", true, sucursal3);
		empleadoDAO.insertarEmpleado(encargado3);

		// Crear vendedores y guardar
		Empleado vendedor1_1 = new Empleado(12345678, "Fernández", "Carlos", "Calle 1", "OSDE", "456789", "50123456789",
				false, sucursal1);
		empleadoDAO.insertarEmpleado(vendedor1_1);
		Empleado vendedor1_2 = new Empleado(23456789, "Pérez", "Laura", "Calle 2", "SWISS", "567890", "60123456789",
				false, sucursal1);
		empleadoDAO.insertarEmpleado(vendedor1_2);
		Empleado vendedor2_1 = new Empleado(34567890, "Gómez", "Luis", "Calle 3", "ACCORD", "678901", "70123456789",
				false, sucursal2);
		empleadoDAO.insertarEmpleado(vendedor2_1);
		Empleado vendedor2_2 = new Empleado(45678901, "Ramírez", "Sofía", "Calle 4", "OSDE", "789012", "80123456789",
				false, sucursal2);
		empleadoDAO.insertarEmpleado(vendedor2_2);
		Empleado vendedor3_1 = new Empleado(56789012, "Díaz", "María", "Calle 5", "SWISS", "890123", "90123456789",
				false, sucursal3);
		empleadoDAO.insertarEmpleado(vendedor3_1);
		Empleado vendedor3_2 = new Empleado(67890123, "Alonso", "Pedro", "Calle 6", "ACCORD", "901234", "10123456789",
				false, sucursal3);
		empleadoDAO.insertarEmpleado(vendedor3_2);

		// Crear clientes y guardar
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(new Cliente(12345678, "González", "María", "Calle 123", "OSDE", "123456"));
		clientes.add(new Cliente(23456789, "Rodríguez", "Juan", "Calle 234", "SWISS", "234567"));
		clientes.add(new Cliente(34567890, "López", "Ana", "Calle 345", null, null));
		clientes.add(new Cliente(45678901, "Martínez", "Carlos", "Calle 456", "OSDE", "456789"));
		clientes.add(new Cliente(56789012, "Gómez", "Laura", "Calle 567", "SWISS", "567890"));
		clientes.add(new Cliente(67890123, "Pérez", "Luis", "Calle 678", null, null));
		clientes.add(new Cliente(78901234, "Sánchez", "Sofía", "Calle 789", "OSDE", "789012"));
		clientes.add(new Cliente(89012345, "Ramírez", "Pedro", "Calle 890", "SWISS", "890123"));
		clientes.add(new Cliente(90123456, "Díaz", "María", "Calle 901", "ACCORD", "901234"));
		clientes.add(new Cliente(12345679, "Alonso", "Juana", "Calle 912", "OSDE", "912345"));
		for (Cliente c : clientes) {
			clienteDAO.insertarCliente(c);
		}

		// Crear productos y guardar
		List<Producto> productos = new ArrayList<>();
		productos.add(new Producto(1, "Aspirina", 10.0f, "Laboratorio A", "Medicamento"));
		productos.add(new Producto(2, "Paracetamol", 8.0f, "Laboratorio B", "Medicamento"));
		productos.add(new Producto(3, "Ibuprofeno", 15.0f, "Laboratorio C", "Medicamento"));
		productos.add(new Producto(4, "Amoxicilina", 20.0f, "Laboratorio D", "Medicamento"));
		productos.add(new Producto(5, "Loratadina", 12.0f, "Laboratorio E", "Medicamento"));
		productos.add(new Producto(6, "Omeprazol", 25.0f, "Laboratorio F", "Medicamento"));
		productos.add(new Producto(7, "Cetirizina", 18.0f, "Laboratorio G", "Medicamento"));
		productos.add(new Producto(8, "Shampoo", 30.0f, "Laboratorio H", "Perfumería"));
		productos.add(new Producto(9, "Jabón", 5.0f, "Laboratorio I", "Perfumería"));
		productos.add(new Producto(10, "Crema Corporal", 45.0f, "Laboratorio J", "Perfumería"));
		for (Producto p : productos) {
			productoDAO.insertarProducto(p);
		}

		// Crear ventas y guardar
		List<Venta> ventas = new ArrayList<>();
		int[] ventasPorSucursal = { 24, 30, 36 }; // Promedio 30 ventas con +/- 20%
		int ventasGeneradas = 0;
		Random random = new Random();
		for (int s = 0; s < 3; s++) {
			Empleado[] vendedores = (s == 0) ? new Empleado[] { vendedor1_1, vendedor1_2, encargado1 }
					: (s == 1) ? new Empleado[] { vendedor2_1, vendedor2_2, encargado2 }
							: new Empleado[] { vendedor3_1, vendedor3_2, encargado3 };

			for (int i = 0; i < ventasPorSucursal[s]; i++) {
				Empleado atendidoPor = vendedores[random.nextInt(3)];
				Empleado cobradoPor = vendedores[random.nextInt(3)];
				Cliente cliente = clientes.get(random.nextInt(clientes.size()));
				int cantidadProductos = 1 + random.nextInt(3); // Entre 1 y 3 productos por venta
				List<DetalleVenta> detallesVenta = new ArrayList<>();
				for (int j = 0; j < cantidadProductos; j++) {
					Producto producto = productos.get(random.nextInt(productos.size()));
					int cantidad = 1 + random.nextInt(5); // Cantidad de cada producto entre 1 y 5
					float precioUnidad = producto.getPrecio();
					DetalleVenta detalleVenta = new DetalleVenta(producto, cantidad, precioUnidad);
					detallesVenta.add(detalleVenta);
				}
				float total = (float) detallesVenta.stream().mapToDouble(d -> d.getTotal()).sum();
				Venta venta = new Venta(ventasGeneradas + 1, LocalDate.now(), total, "Efectivo", cliente, atendidoPor,
						cobradoPor, detallesVenta);
				ventas.add(venta);
				ventaDAO.insertarVenta(venta);
				ventasGeneradas++;
			}
		}
		mongoClient.close();
	}
}
