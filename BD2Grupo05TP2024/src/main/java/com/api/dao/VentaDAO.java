package com.api.dao;

import java.time.LocalDate;

import org.bson.Document;

import com.api.model.Venta;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

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
		Document filtro = new Document("nroTicket", nroTicket); // creo un filtro para buscar por _id
		Document ventaDoc = collection.find(filtro).first(); // busco el documento en la colección
		if (ventaDoc != null) {
			return gson.fromJson(ventaDoc.toJson(), Venta.class);
		}
		return null;
	}
}
