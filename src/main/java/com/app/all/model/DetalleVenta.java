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
	private int cantidad;
	private LocalDate fecha;
	private String tipoPago;

	// fetch = FetchType.LAZY, cascade = CascadeType.ALL

	@OneToMany(targetEntity = Producto.class)
	private List<Producto> productos;

	public DetalleVenta() {
		super();
	}

	public DetalleVenta(Integer idVenta, double total, double precio, int cantidad, LocalDate fecha, String tipoPago,
			List<Producto> productos) {
		super();
		this.idVenta = idVenta;
		this.total = total;
		this.precio = precio;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.tipoPago = tipoPago;
		this.productos = productos;
	}

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "DetalleVenta [idVenta=" + idVenta + ", total=" + total + ", precio=" + precio + ", cantidad=" + cantidad
				+ ", fecha=" + fecha + ", tipoPago=" + tipoPago + ", productos=" + productos + "]";
	}

}
