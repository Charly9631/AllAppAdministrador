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
@Table(name="abonos")
public class Abono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAbono;
	private Date fecha;
	private double cantidad;
	private double saldoTotal;
	
	

	
	
	
}
