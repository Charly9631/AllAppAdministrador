package com.app.all.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="creditos")
public class Credito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCredito;
	private double saldoTotal;
	private Date fecha;
	
	@ManyToMany
	private Producto producto;
	
	@ManyToMany
	private Cliente cliente;
	
	@ManyToMany(mappedBy="creditos")
	private List<TipoVenta> tipoVenta;
	
	
}
