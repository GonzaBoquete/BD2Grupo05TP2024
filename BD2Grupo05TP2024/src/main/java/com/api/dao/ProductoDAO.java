package com.api.dao;

import org.bson.Document;

import com.api.model.Producto;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ProductoDAO {
	private MongoCollection<Document> collection;
	private Gson gson;

	public ProductoDAO(MongoDatabase database) {
		this.collection = database.getCollection("Producto");
		this.gson = new Gson();
	}

	public void insertarProducto(Producto producto) {
		if (this.getProducto(producto.getCodigo()) == null) {
			String jsonProducto = gson.toJson(producto); // convierto el objeto Producto a JSON usando Gson
			Document productoDoc = Document.parse(jsonProducto); // convierto el JSON a un documento BSON
			collection.insertOne(productoDoc); // inserto el documento en la colección
			System.out.println("El Producto con codigo " + producto.getCodigo() + " se dio de alta correctamente.");
		} else {
			System.out.println("El Producto con codigo " + producto.getCodigo() + " ya se encuentra en la base.");
		}
	}

	public Producto getProducto(int codigo) {
		Document filtro = new Document("codigo", codigo); // creo un filtro para buscar por _id
		Document productoDoc = collection.find(filtro).first(); // busco el documento en la colección
		if (productoDoc != null) {
			return gson.fromJson(productoDoc.toJson(), Producto.class);
		}
		return null;
	}
}
