package com.app.all.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	private String nombre;
	private double saldo;
	private int status;
	private String telefono;
	private String direccion;

	@OneToMany(targetEntity = Abono.class)
	private List<Abono> abonos;

	public Cliente() {
		super();
	}

	public Cliente(Integer idCliente, String nombre, double saldo, int status, String telefono, String direccion) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.saldo = saldo;
		this.status = status;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", saldo=" + saldo + ", status=" + status
				+ ", telefono=" + telefono + ", direccion=" + direccion + "]";
	}

}
