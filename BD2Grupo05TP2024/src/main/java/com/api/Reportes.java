package com.api;

import java.time.LocalDate;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Reportes {

	public static void main(String[] args) {
		LocalDate fechaDesde = LocalDate.of(2024, 1, 1); // Ejemplo: fecha desde
		LocalDate fechaHasta = LocalDate.of(2024, 5, 31); // Ejemplo: fecha hasta

		generarReporte(fechaDesde, fechaHasta);
	}

	public static void generarReporte(LocalDate fechaDesde, LocalDate fechaHasta) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = mongoClient.getDatabase("BD2Grupo05TP2024");
		MongoCollection<Document> collection = database.getCollection("Venta");

		mongoClient.close();
	}
}
