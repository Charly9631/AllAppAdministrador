package com.app.all.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "creditos")
public class Credito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCredito;
	private double saldoTotal;
	private Date fecha;

	@OneToOne
	private Cliente cliente;

	@OneToOne
	private DetalleVenta detalleVentas;

	@OneToMany(targetEntity = Abono.class)
	private List<Abono> abonos;

	public Credito() {
		super();
	}

	public Credito(Integer idCredito, double saldoTotal, Date fecha, Cliente cliente, DetalleVenta detalleVentas,
			List<Abono> abonos) {
		super();
		this.idCredito = idCredito;
		this.saldoTotal = saldoTotal;
		this.fecha = fecha;
		this.cliente = cliente;
		this.detalleVentas = detalleVentas;
		this.abonos = abonos;
	}

	public Integer getIdCredito() {
		return idCredito;
	}

	public void setIdCredito(Integer idCredito) {
		this.idCredito = idCredito;
	}

	public double getSaldoTotal() {
		return saldoTotal;
	}

	public void setSaldoTotal(double saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public DetalleVenta getDetalleVentas() {
		return detalleVentas;
	}

	public void setDetalleVentas(DetalleVenta detalleVentas) {
		this.detalleVentas = detalleVentas;
	}

	public List<Abono> getAbonos() {
		return abonos;
	}

	public void setAbonos(List<Abono> abonos) {
		this.abonos = abonos;
	}

	@Override
	public String toString() {
		return "Credito [idCredito=" + idCredito + ", saldoTotal=" + saldoTotal + ", fecha=" + fecha + ", cliente="
				+ cliente + ", detalleVentas=" + detalleVentas + ", abonos=" + abonos + "]";
	}

}
