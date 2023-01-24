package com.app.all.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.all.model.DetalleVenta;
import com.app.all.service.DetalleVentaService;

@RestController
@RequestMapping("/detalleVenta")
public class DetalleVentaController {

	@Autowired
	public DetalleVentaService detalleVentaService;

	@GetMapping("")
	public List<DetalleVenta> listarDetalleVenta() {
		return detalleVentaService.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalleVenta> obtenerPorId(@PathVariable Integer id) {
		try {
			DetalleVenta detalleVenta = detalleVentaService.obtenerDetalleVenta(id);
			return new ResponseEntity<DetalleVenta>(detalleVenta, HttpStatus.OK);
		} catch (Exception excepcion) {
			return new ResponseEntity<DetalleVenta>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/guardar")
	public void guardarDetalleVenta(DetalleVenta detalleVenta) {
		detalleVentaService.guardarDetalleVenta(detalleVenta);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualizarDetalleVenta(@RequestBody DetalleVenta detalleVenta, @PathVariable Integer id) {
		try {
			DetalleVenta detalleVentaExistente = detalleVentaService.obtenerDetalleVenta(id);

			detalleVentaService.guardarDetalleVenta(detalleVentaExistente);
			return new ResponseEntity<DetalleVenta>(detalleVentaExistente, HttpStatus.OK);
		} catch (Exception excepcion) {
			return new ResponseEntity<DetalleVenta>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminarDetalleVenta(@PathVariable Integer id) {
		detalleVentaService.eliminarDetalleVenta(id);
	}
}
