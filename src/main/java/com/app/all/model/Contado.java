package com.app.all.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contados")
public class Contado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idContado;
	
	@OneToOne
	private DetalleVenta detalleVentas;
	
	


	
}
