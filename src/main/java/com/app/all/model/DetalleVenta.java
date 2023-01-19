package com.app.all.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private LocalDate fecha;
	private String tipoPago;

	//fetch = FetchType.LAZY, cascade = CascadeType.ALL
	
	@OneToMany( targetEntity=Producto.class )
	   private List<Producto> productos;
	

}
