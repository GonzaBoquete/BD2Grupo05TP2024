package com.api;

import java.time.LocalDate;
import java.util.Arrays;

import org.bson.Document;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Reportes {

	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("BD2Grupo05TP2024");
        MongoCollection<Document> collection = database.getCollection("Venta");

        LocalDate fechaInicio = LocalDate.of(2023, 1, 1); // Enero 1, 2023
        LocalDate fechaFin = LocalDate.of(2023, 11, 30); // Diciembre 31, 2023

        // Total de ventas de toda la cadena completa
        AggregateIterable<Document> totalCadena = collection.aggregate(Arrays.asList(
            new Document("$match", new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin))),
            new Document("$group", new Document("_id", null).append("totalVentas", new Document("$sum", 1)))
        ));

        // Ventas agrupadas por sucursales
        AggregateIterable<Document> ventasPorSucursal = collection.aggregate(Arrays.asList(
            new Document("$match", new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin))),
            new Document("$group", new Document("_id", "$sucursal.idSucursal").append("totalVentas", new Document("$sum", 1)))
        ));

        System.out.println("Total de ventas de toda la cadena:");
        for (Document doc : totalCadena) {
            System.out.println(doc.toJson());
        }

        System.out.println("\nVentas por sucursales:");
        for (Document doc : ventasPorSucursal) {
            System.out.println(doc.toJson());
        }

        mongoClient.close();
    }

}
