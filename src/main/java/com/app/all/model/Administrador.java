package com.app.all.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="administradors")
public class Administrador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAdministrador;
	private String nombre;
	private String telefono;
	private String user;
	private String password;
	
	public Administrador() {
		super();
	}

	public Administrador(Integer idAdministrador, String nombre, String telefono, String user, String password) {
		super();
		this.idAdministrador = idAdministrador;
		this.nombre = nombre;
		this.telefono = telefono;
		this.user = user;
		this.password = password;
	}

	public Integer getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(Integer idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrador [idAdministrador=" + idAdministrador + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", user=" + user + ", password=" + password + "]";
	}
	
	
	
	
}
