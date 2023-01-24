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

import com.app.all.model.Credito;
import com.app.all.service.CreditoService;

@RestController
@RequestMapping("/credito")
public class CreditoController {

	@Autowired
	public CreditoService creditoService;

	@GetMapping("")
	public List<Credito> listarCredito() {
		return creditoService.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Credito> obtenerPorId(@PathVariable Integer id) {
		try {
			Credito credito = creditoService.obtenerCredito(id);
			return new ResponseEntity<Credito>(credito, HttpStatus.OK);
		} catch (Exception excepcion) {
			return new ResponseEntity<Credito>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/guardar")
	public void guardarCredito(Credito credito) {
		creditoService.guardarCredito(credito);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualizarCredito(@RequestBody Credito credito, @PathVariable Integer id) {
		try {
			Credito creditoExistente = creditoService.obtenerCredito(id);

			creditoExistente.setFecha(credito.getFecha());
			creditoExistente.setSaldoTotal(credito.getSaldoTotal());
			creditoExistente.setCliente(credito.getCliente());
			creditoExistente.setAbonos(credito.getAbonos());
			creditoExistente.setDetalleVentas(credito.getDetalleVentas());

			creditoService.guardarCredito(creditoExistente);
			return new ResponseEntity<Credito>(creditoExistente, HttpStatus.OK);
		} catch (Exception excepcion) {
			return new ResponseEntity<Credito>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminarCredito(@PathVariable Integer id) {
		creditoService.eliminarCredito(id);
	}
}
