package com.api.dao;

import org.bson.Document;

import com.api.model.Sucursal;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class SucursalDAO {
	private MongoCollection<Document> collection;
	private Gson gson;

	public SucursalDAO(MongoDatabase database) {
		this.collection = database.getCollection("Sucursal");
		this.gson = new Gson();
	}

	public void insertarSucursal(Sucursal sucursal) {
		if (this.getSucursal(sucursal.getIdSucursal()) == null) {
			String jsonSucursal = gson.toJson(sucursal); // convierto el objeto Sucursal a JSON usando Gson
			Document sucursalDoc = Document.parse(jsonSucursal); // convierto el JSON a un documento BSON
			collection.insertOne(sucursalDoc); // inserto el documento en la colección
			System.out.println("La sucursal con idSucursal " + sucursal.getIdSucursal() + " se dio de alta correctamente.");
		} else {
			System.out.println("La sucursal con idSucursal " + sucursal.getIdSucursal() + " ya se encuentra en la base.");
		}
	}

	public Sucursal getSucursal(int idSucursal) {
		Document filtro = new Document("idSucursal", idSucursal); // creo un filtro para buscar por _id
		Document sucursalDoc = collection.find(filtro).first(); // busco el documento en la colección
		if (sucursalDoc != null) {
			return gson.fromJson(sucursalDoc.toJson(), Sucursal.class);
		}
		return null;
	}
}
