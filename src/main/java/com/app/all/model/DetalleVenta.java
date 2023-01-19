package com.app.all.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalleVentas")
public class DetalleVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVenta;

	private double total;
	private double precio;
	private Date fecha;
	private String tipoPago;

	//fetch = FetchType.LAZY, cascade = CascadeType.ALL
	
	@OneToMany( targetEntity=Producto.class )
	   private List<Producto> productos;
	

}
