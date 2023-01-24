package com.app.all.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.all.model.DetalleVenta;
import com.app.all.repository.DetalleVentaRepository;

@Service
public class DetalleVentaService {

	@Autowired
	public DetalleVentaRepository detalleVentaRepository;

	public List<DetalleVenta> listar() {
		return detalleVentaRepository.findAll();
	}

	public void guardarDetalleVenta(DetalleVenta detalleVenta) {
		detalleVentaRepository.save(detalleVenta);
	}

	public DetalleVenta obtenerDetalleVenta(Integer id) {
		return detalleVentaRepository.findById(id).get();
	}

	public void eliminarDetalleVenta(Integer id) {
		detalleVentaRepository.deleteById(id);
	}
}
