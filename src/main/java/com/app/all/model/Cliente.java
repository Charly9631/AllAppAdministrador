package com.app.all.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	private String nombre;
	private double saldo;
	private int status;
	
	@ManyToMany(mappedBy="clientes")
	private List<Abono> abonos;
	
	@ManyToMany(mappedBy="clientes")
	private List<Credito> credito;
	
	public Cliente() {
		super();
	}

	public Cliente(Integer idCliente, String nombre, double saldo, int status) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.saldo = saldo;
		this.status = status;
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

	@Override
	public String toString() {
		return "Cliente [id=" + idCliente + ", nombre=" + nombre + ", saldo=" + saldo + ", status=" + status + "]";
	}
	
	
	
}
