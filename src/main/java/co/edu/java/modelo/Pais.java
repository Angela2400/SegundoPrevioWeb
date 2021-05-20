package co.edu.java.modelo;

import java.io.Serializable;

public class Pais implements Serializable {
	private String id;
	private String nombre;
	
	public Pais() {
	}
	
	public Pais(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
