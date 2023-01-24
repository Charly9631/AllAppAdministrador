package com.app.all.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "abonos")
public class Abono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAbono;
	private Date fecha;
	private double cantidad;
	private double saldoTotal;

	@ManyToOne
	public Credito credito;

	public Abono() {
		super();
	}

	public Abono(Integer idAbono, Date fecha, double cantidad, double saldoTotal, Credito credito) {
		super();
		this.idAbono = idAbono;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.saldoTotal = saldoTotal;
		this.credito = credito;
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

	public double getSaldoTotal() {
		return saldoTotal;
	}

	public void setSaldoTotal(double saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	public Credito getCredito() {
		return credito;
	}

	public void setCredito(Credito credito) {
		this.credito = credito;
	}

	@Override
	public String toString() {
		return "Abono [idAbono=" + idAbono + ", fecha=" + fecha + ", cantidad=" + cantidad + ", saldoTotal="
				+ saldoTotal + "]";
	}

}
