package co.edu.java.modelo;

import java.io.Serializable;

public class Equipo implements Serializable {
	private String id;
	private String nombre;
	private String pais;

	public Equipo() {
	}
	
	public Equipo(String id, String nombre, String pais) {
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
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
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
}
