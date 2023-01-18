package com.app.all.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVenta;

	private double precio;
	private Date fecha;
	private String tipoPago;

	@ManyToOne
	private Producto producto;

	@ManyToOne
	private TipoVenta tipoVenta;

	public Venta() {
		super();
	}

	public Venta(Integer idVenta, double precio, Date fecha, String tipoPago, Producto producto, TipoVenta tipoVenta) {
		super();
		this.idVenta = idVenta;
		this.precio = precio;
		this.fecha = fecha;
		this.tipoPago = tipoPago;
		this.producto = producto;
		this.tipoVenta = tipoVenta;
	}

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public TipoVenta getTipoVenta() {
		return tipoVenta;
	}

	public void setTipoVenta(TipoVenta tipoVenta) {
		this.tipoVenta = tipoVenta;
	}

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", precio=" + precio + ", fecha=" + fecha + ", tipoPago=" + tipoPago
				+ ", producto=" + producto + ", tipoVenta=" + tipoVenta + "]";
	}

}
