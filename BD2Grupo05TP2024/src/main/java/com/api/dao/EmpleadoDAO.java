package com.api.dao;

import org.bson.Document;

import com.api.model.Empleado;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class EmpleadoDAO {
	private MongoCollection<Document> collection;
	private Gson gson;

	public EmpleadoDAO(MongoDatabase database) {
		this.collection = database.getCollection("Empleado");
		this.gson = new Gson();
	}

	public void insertarEmpleado(Empleado empleado) {
		if (this.getEmpleado(empleado.getDNI()) == null) {
			String jsonEmpleado = gson.toJson(empleado); // convierto el objeto Empleado a JSON usando Gson
			Document empleadoDoc = Document.parse(jsonEmpleado); // convierto el JSON a un documento BSON
			collection.insertOne(empleadoDoc); // inserto el documento en la colección
			System.out.println("El Empleado con DNI " + empleado.getDNI() + " se dio de alta correctamente.");
		} else {
			System.out.println("El Empleado con DNI " + empleado.getDNI() + " ya se encuentra en la base.");
		}
	}

	public Empleado getEmpleado(int DNI) {
		Document filtro = new Document("DNI", DNI); // creo un filtro para buscar por _id
		Document empleadoDoc = collection.find(filtro).first(); // busco el documento en la colección
		if (empleadoDoc != null) {
			return gson.fromJson(empleadoDoc.toJson(), Empleado.class);
		}
		return null;
	}
}
