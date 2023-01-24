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

import com.app.all.model.Contado;
import com.app.all.service.ContadoService;

@RestController
@RequestMapping("/contado")
public class ContadoController {

	@Autowired
	public ContadoService contadoService;

	@GetMapping("")
	public List<Contado> listarContado() {
		return contadoService.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Contado> obtenerPorId(@PathVariable Integer id) {
		try {
			Contado contado = contadoService.obtenerContado(id);
			return new ResponseEntity<Contado>(contado, HttpStatus.OK);
		} catch (Exception excepcion) {
			return new ResponseEntity<Contado>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/guardar")
	public void guardarContado(Contado contado) {
		contadoService.guardarContado(contado);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualizarContado(@RequestBody Contado contado, @PathVariable Integer id) {
		try {
			Contado contadoExistente = contadoService.obtenerContado(id);

			contadoExistente.setDetalleVentas(contado.getDetalleVentas());

			contadoService.guardarContado(contadoExistente);
			return new ResponseEntity<Contado>(contadoExistente, HttpStatus.OK);
		} catch (Exception excepcion) {
			return new ResponseEntity<Contado>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminarContado(@PathVariable Integer id) {
		contadoService.eliminarContado(id);
	}

}
