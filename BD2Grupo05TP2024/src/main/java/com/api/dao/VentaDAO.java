package com.api.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.api.model.Venta;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;

public class VentaDAO {
	private MongoCollection<Document> collection;
	Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();

	public VentaDAO(MongoDatabase database) {
		this.collection = database.getCollection("Venta");
		this.gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
	}

	public void insertarVenta(Venta venta) {
		if (this.getVenta(venta.getNroTicket()) == null) {
			String jsonVenta = gson.toJson(venta); // convierto el objeto Venta a JSON usando Gson
			Document ventaDoc = Document.parse(jsonVenta); // convierto el JSON a un documento BSON
			collection.insertOne(ventaDoc); // inserto el documento en la colección
			System.out.println("La Venta con NroTicket " + venta.getNroTicket() + " se dio de alta correctamente.");
		} else {
			System.out.println("La Venta con NroTicket " + venta.getNroTicket() + " ya se encuentra en la base.");
		}
	}

	public Venta getVenta(int nroTicket) {
		Document filtro = new Document("nroTicket", nroTicket); // Creo un filtro para buscar por _id
		Document ventaDoc = collection.find(filtro).first(); // Busco el documento en la colección
		if (ventaDoc != null) {
			return gson.fromJson(ventaDoc.toJson(), Venta.class);
		}
		return null;
	}

	public List<Document> totalVentasTodaCadena(LocalDate fechaDesde, LocalDate fechaHasta) {
		// Filtro por fecha
		Bson match = Aggregates.match(
				Filters.and(Filters.gte("fecha", fechaDesde.toString()), Filters.lte("fecha", fechaHasta.toString())));
		//Agrupo por todos los registros obtenidos bajo una sola variable "totalVentas"
		Bson group = Aggregates.group(null, Accumulators.sum("totalVentas", 1));
		//Se formula una pipeline a traves de los filtros que acabamos de crear
		List<Bson> pipeline = Arrays.asList(match, group);
		return collection.aggregate(pipeline).into(new ArrayList<>());
	}

	public List<Document> totalVentasPorSucursal(LocalDate fechaDesde, LocalDate fechaHasta) {
		// Filtro por fecha
		Bson match = Aggregates.match(
				Filters.and(Filters.gte("fecha", fechaDesde.toString()), Filters.lte("fecha", fechaHasta.toString())));
		//Agrupo por idSucursal bajo una sola variable "totalVentas"
		Bson group = Aggregates.group("$atendidoPor.sucursal.idSucursal", Accumulators.sum("totalVentas", 1));
		//Se formula una pipeline con los filtros que acabamos de crear
		List<Bson> pipeline = Arrays.asList(match, group);
		return collection.aggregate(pipeline).into(new ArrayList<>());
	}

	public List<Document> totalVentasPorObraSocial(LocalDate fechaDesde, LocalDate fechaHasta) {
		// Filtro por fecha
		Bson match = Aggregates.match(
				Filters.and(Filters.gte("fecha", fechaDesde.toString()), Filters.lte("fecha", fechaHasta.toString())));
		//Agrupo por obra social del cliente bajo una sola variable "totalVentas"
		Bson group = Aggregates.group("$cliente.obraSocial", Accumulators.sum("totalVentas", 1));
		//Se formula una pipeline con los filtros que acabamos de crear
		List<Bson> pipeline = Arrays.asList(match, group);
		return collection.aggregate(pipeline).into(new ArrayList<>());
	}

	public List<Document> totalCobranzaTodaCadena(LocalDate fechaDesde, LocalDate fechaHasta) {
		// Filtro por fecha
		Bson match = Aggregates.match(
				Filters.and(Filters.gte("fecha", fechaDesde.toString()), Filters.lte("fecha", fechaHasta.toString())));
		//Acumulo el valor de "valorVenta" bajo "totalCobranza"
		Bson group = Aggregates.group(null, Accumulators.sum("totalCobranza", "$valorVenta"));
		//Se formula una pipeline con los filtros que acabamos de crear
		List<Bson> pipeline = Arrays.asList(match, group);
		return collection.aggregate(pipeline).into(new ArrayList<>());
	}

	public List<Document> totalCobranzaPorSucursal(LocalDate fechaDesde, LocalDate fechaHasta) {
		// Filtro por fecha
		Bson match = Aggregates.match(
				Filters.and(Filters.gte("fecha", fechaDesde.toString()), Filters.lte("fecha", fechaHasta.toString())));
		//Agrupo por idSucursal y acumulo el valor de "valorVenta" bajo "totalCobranza"
		Bson group = Aggregates.group("$atendidoPor.sucursal.idSucursal",
				Accumulators.sum("totalCobranza", "$valorVenta"));
		//Se formula una pipeline con los filtros que acabamos de crear
		List<Bson> pipeline = Arrays.asList(match, group);
		return collection.aggregate(pipeline).into(new ArrayList<>());
	}

	public List<Document> ventasPorTipoProducto(LocalDate fechaDesde, LocalDate fechaHasta) {
		// Filtro por fecha
		Bson match = Aggregates.match(
				Filters.and(Filters.gte("fecha", fechaDesde.toString()), Filters.lte("fecha", fechaHasta.toString())));
		//accedo al objeto "detallesVenta" dentro de "Venta"
		Bson unwind = Aggregates.unwind("$detallesVenta");
		//Agrupo por tipo de producto y acumulo las cantidades de "detalleVenta" bajo "totalVentas"
		Bson group = Aggregates.group("$detallesVenta.producto.tipo",
				Accumulators.sum("totalVentas", "$detallesVenta.cantidad"));
		//Se formula una pipeline con los filtros que acabamos de crear
		List<Bson> pipeline = Arrays.asList(match, unwind, group);
		return collection.aggregate(pipeline).into(new ArrayList<>());
	}

	public List<Document> rankingMontoVendido() {
		//accedo al objeto "detallesVenta" dentro de "Venta"
		Bson unwind = Aggregates.unwind("$detallesVenta");
		//Agrupo por codigo de producto e idSucursal y acumulo los totales de "detalleVenta" bajo "totalMonto"
		Bson group = Aggregates.group(Arrays.asList("$detallesVenta.producto.codigo", "$sucursal.idSucursal"),
				Accumulators.sum("totalMonto", "$detallesVenta.total"));
		//Ordeno de mayor a menor por "totalMonto"
		Bson sort = Aggregates.sort(Sorts.descending("totalMonto"));
		//Se formula una pipeline con los filtros que acabamos de crear
		List<Bson> pipeline = Arrays.asList(unwind, group, sort);
		return collection.aggregate(pipeline).into(new ArrayList<>());
	}

	public List<Document> rankingCantidadProductosVendidos() {
		//accedo al objeto "detallesVenta" dentro de "Venta"
		Bson unwind = Aggregates.unwind("$detallesVenta");
		//Agrupo por codigo de producto e idSucursal y acumulo las cantidades de "detalleVenta" bajo "totalCantidad"
		Bson group = Aggregates.group(Arrays.asList("$detallesVenta.producto.codigo", "$sucursal.idSucursal"),
				Accumulators.sum("totalCantidad", "$detallesVenta.cantidad"));
		//Ordeno de mayor a menor por "totalCantidad"
		Bson sort = Aggregates.sort(Sorts.descending("totalCantidad"));
		//Se formula una pipeline con los filtros que acabamos de crear
		List<Bson> pipeline = Arrays.asList(unwind, group, sort);
		return collection.aggregate(pipeline).into(new ArrayList<>());
	}

	public List<Document> rankingComprasPorCliente() {
		//Agrupo por DNI de cliente y acumulo los valores de "valorVenta" bajo "totalCompras"
		Bson group = Aggregates.group("$cliente.DNI", Accumulators.sum("totalCompras", "$valorVenta"));
		//Ordeno de mayor a menor por "totalCompras"
		Bson sort = Aggregates.sort(Sorts.descending("totalCompras"));
		//Se formula una pipeline con los filtros que acabamos de crear
		List<Bson> pipeline = Arrays.asList(group, sort);
		return collection.aggregate(pipeline).into(new ArrayList<>());
	}

	public List<Document> rankingComprasPorClienteYSucursal() {
		//Agrupo por DNI de cliente e idSucursal y acumulo los valores de "valorVenta" bajo "totalCompras"
		Bson group = Aggregates.group(Arrays.asList("$cliente.DNI", "$sucursal.idSucursal"),
				Accumulators.sum("totalCompras", "$valorVenta"));
		//Ordeno de mayor a menor por "totalCompras"
		Bson sort = Aggregates.sort(Sorts.descending("totalCompras"));
		//Se formula una pipeline con los filtros que acabamos de crear
		List<Bson> pipeline = Arrays.asList(group, sort);
		return collection.aggregate(pipeline).into(new ArrayList<>());
	}
}
