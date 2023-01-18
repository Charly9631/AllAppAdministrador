package com.app.all.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contados")
public class Contado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idContado;
	private double ganancia;
	
	@ManyToOne
	private Producto producto;
	
	@ManyToMany(mappedBy="contados")
	private List<TipoVenta> tipoVenta;

	public Contado() {
		super();
	}

	public Contado(Integer idContado, double ganancia, Producto producto) {
		super();
		this.idContado = idContado;
		this.ganancia = ganancia;
		this.producto = producto;
	}

	public Integer getIdContado() {
		return idContado;
	}

	public void setIdContado(Integer idContado) {
		this.idContado = idContado;
	}

	public double getGanancia() {
		return ganancia;
	}

	public void setGanancia(double ganancia) {
		this.ganancia = ganancia;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Contado [idContado=" + idContado + ", ganancia=" + ganancia + ", producto=" + producto + "]";
	}
	
	
	
}
