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

import com.app.all.model.Abono;
import com.app.all.service.AbonoService;

@RestController
@RequestMapping("/abono")
public class AbonoController {

	@Autowired
	public AbonoService abonoService;

	@GetMapping("")
	public List<Abono> listarAbono() {
		return abonoService.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Abono> obtenerPorId(@PathVariable Integer id) {
		try {
			Abono abono = abonoService.obtenerAbono(id);
			return new ResponseEntity<Abono>(abono, HttpStatus.OK);
		} catch (Exception excepcion) {
			return new ResponseEntity<Abono>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/guardar")
	public void guardarAbono(Abono abono) {
		abonoService.guardarAbono(abono);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualizarAbono(@RequestBody Abono abono, @PathVariable Integer id) {
		try {
			Abono abonoExistente = abonoService.obtenerAbono(id);

			abonoExistente.setCantidad(abono.getCantidad());
			abonoExistente.setFecha(abono.getFecha());
			abonoExistente.setCantidad(abono.getCantidad());
			abonoExistente.setSaldoTotal(abono.getSaldoTotal());
			abonoExistente.setCredito(abono.getCredito());

			abonoService.guardarAbono(abonoExistente);
			return new ResponseEntity<Abono>(abonoExistente, HttpStatus.OK);
		} catch (Exception excepcion) {
			return new ResponseEntity<Abono>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminarAbono(@PathVariable Integer id) {
		abonoService.eliminarAbono(id);
	}
}
