package co.edu.java.modelo;

import java.io.Serializable;
import java.util.Date;

public class Ciclista implements Serializable {
	private Integer id;
	private String nombre;
	private String email;
	private Date cumplea�os;
	private String pais;
	private String equipo;
	
	public Ciclista() {
		
	}
	
	public Ciclista(Integer id, String nombre, String email, Date cumplea�os, String pais, String equipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.cumplea�os = cumplea�os;
		this.pais = pais;
		this.equipo = equipo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCumplea�os() {
		return cumplea�os;
	}
	public void setCumplea�os(Date cumplea�os) {
		this.cumplea�os = cumplea�os;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	
	
}
