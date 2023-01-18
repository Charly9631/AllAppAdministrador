package com.app.all.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="abonos")
public class Abono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAbono;
	private Date fecha;
	private double cantidad;
	
	private Cliente cliente;
	
	public Abono() {
		super();
	}

	

	public Abono(Integer idAbono, Date fecha, double cantidad, Cliente cliente) {
		super();
		this.idAbono = idAbono;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.cliente = cliente;
	}



	public Integer getIdAbono() {
		return idAbono;
	}

	public void setIdAbono(Integer idAbono) {
		this.idAbono = idAbono;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Abono [idAbono=" + idAbono + ", fecha=" + fecha + ", cantidad=" + cantidad + "]";
	}
	
	
	
	
}
