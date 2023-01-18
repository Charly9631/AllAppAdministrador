package com.app.all.model;

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
@Table(name="tipoVentas")
public class TipoVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoVenta;
	
	@ManyToMany
	private Credito credito;
	
	@ManyToMany
	private Contado contado;
	
	@OneToMany(mappedBy="tipoVentas")
	private List<Venta> venta;

	public Integer getIdTipoVenta() {
		return idTipoVenta;
	}

	public void setIdTipoVenta(Integer idTipoVenta) {
		this.idTipoVenta = idTipoVenta;
	}

	public TipoVenta() {
		super();
	}

	public TipoVenta(Integer idTipoVenta) {
		super();
		this.idTipoVenta = idTipoVenta;
	}

	@Override
	public String toString() {
		return "TipoVenta [idTipoVenta=" + idTipoVenta + "]";
	}
	
	
}
