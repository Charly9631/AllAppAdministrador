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

import com.app.all.model.Administrador;
import com.app.all.service.AdministradorService;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	public AdministradorService administradorService;

	@GetMapping("")
	public List<Administrador> listarAdministrador() {
		return administradorService.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Administrador> obtenerPorId(@PathVariable Integer id) {
		try {
			Administrador administrador = administradorService.obtenerAdministrador(id);
			return new ResponseEntity<Administrador>(administrador, HttpStatus.OK);
		} catch (Exception excepcion) {
			return new ResponseEntity<Administrador>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/guardar")
	public void guardarAdministrador(Administrador administrador) {
		administradorService.guardarAdministrador(administrador);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualizarAdministrador(@RequestBody Administrador administrador,
			@PathVariable Integer id) {
		try {
			Administrador administradorExistente = administradorService.obtenerAdministrador(id);

			administradorExistente.setNombre(administrador.getNombre());
			administradorExistente.setPassword(administrador.getPassword());
			administradorExistente.setTelefono(administrador.getTelefono());
			administradorExistente.setUser(administrador.getUser());

			administradorService.guardarAdministrador(administradorExistente);
			return new ResponseEntity<Administrador>(administradorExistente, HttpStatus.OK);
		} catch (Exception excepcion) {
			return new ResponseEntity<Administrador>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminarAdministrador(@PathVariable Integer id) {
		administradorService.eliminarAdministrador(id);
	}

}
