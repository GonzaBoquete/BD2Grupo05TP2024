package com.api.dao;

import org.bson.Document;

import com.api.model.Cliente;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ClienteDAO {
	private MongoCollection<Document> collection;
	private Gson gson;

	public ClienteDAO(MongoDatabase database) {
		this.collection = database.getCollection("Cliente");
		this.gson = new Gson();
	}

	public void insertarCliente(Cliente cliente) {
		if (this.getCliente(cliente.getDNI()) == null) {
			String jsonCliente = gson.toJson(cliente); // convierto el objeto Cliente a JSON usando Gson
			Document clienteDoc = Document.parse(jsonCliente); // convierto el JSON a un documento BSON
			collection.insertOne(clienteDoc); // inserto el documento en la colección
			System.out.println("El Cliente con DNI " + cliente.getDNI() + " se dio de alta correctamente.");
		} else {
			System.out.println("El Cliente con DNI " + cliente.getDNI() + " ya se encuentra en la base.");
		}
	}

	public Cliente getCliente(int DNI) {
		Document filtro = new Document("DNI", DNI); // creo un filtro para buscar por _id
		Document clienteDoc = collection.find(filtro).first(); // busco el documento en la colección
		if (clienteDoc != null) {
			return gson.fromJson(clienteDoc.toJson(), Cliente.class);
		} else {
			return null;
		}
	}
}
