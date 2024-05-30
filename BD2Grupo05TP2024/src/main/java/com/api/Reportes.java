package com.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.bson.Document;

import com.api.dao.VentaDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Reportes {

	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = mongoClient.getDatabase("BD2Grupo05TP2024");
		VentaDAO ventaDAO = new VentaDAO(database);

		LocalDate fechaDesde = LocalDate.parse("2023-01-01", DateTimeFormatter.ISO_DATE);
		LocalDate fechaHasta = LocalDate.parse("2024-12-31", DateTimeFormatter.ISO_DATE);

		List<Document> totalVentasTodaCadena = ventaDAO.totalVentasTodaCadena(fechaDesde, fechaHasta);
		System.out.println("1.1 Total ventas en toda la cadena: " + totalVentasTodaCadena);

		List<Document> totalVentasPorSucursal = ventaDAO.totalVentasPorSucursal(fechaDesde, fechaHasta);
		System.out.println("1.2 Total ventas por sucursal: " + totalVentasPorSucursal);

		List<Document> totalVentasPorObraSocial = ventaDAO.totalVentasPorObraSocial(fechaDesde, fechaHasta);
		System.out.println("2. Total ventas por obra social: " + totalVentasPorObraSocial);

		List<Document> totalCobranzaTodaCadena = ventaDAO.totalCobranzaTodaCadena(fechaDesde, fechaHasta);
		System.out.println("3.1 Total cobranza en toda la cadena: " + totalCobranzaTodaCadena);

		List<Document> totalCobranzaPorSucursal = ventaDAO.totalCobranzaPorSucursal(fechaDesde, fechaHasta);
		System.out.println("3.2. Total cobranza por sucursal: " + totalCobranzaPorSucursal);

		List<Document> ventasPorTipoProducto = ventaDAO.ventasPorTipoProducto(fechaDesde, fechaHasta);
		System.out.println("4. Total ventas por tipo de producto: " + ventasPorTipoProducto);

		List<Document> rankingMontoVendido = ventaDAO.rankingMontoVendido();
		System.out.println("5. Ranking monto vendido: " + rankingMontoVendido);

		List<Document> rankingCantidadProductosVendidos = ventaDAO.rankingCantidadProductosVendidos();
		System.out.println("6. Ranking cantidad productos vendidos: " + rankingCantidadProductosVendidos);

		List<Document> rankingComprasPorCliente = ventaDAO.rankingComprasPorCliente();
		System.out.println("7. Ranking compras por cliente: " + rankingComprasPorCliente);

		List<Document> rankingComprasPorClienteYSucursal = ventaDAO.rankingComprasPorClienteYSucursal();
		System.out.println("8. Ranking compras por cliente y sucursal: " + rankingComprasPorClienteYSucursal);

		mongoClient.close();
	}
}
