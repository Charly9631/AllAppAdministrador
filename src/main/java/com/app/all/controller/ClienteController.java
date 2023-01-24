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

import com.app.all.model.Cliente;
import com.app.all.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	public ClienteService clienteService;

	@GetMapping("")
	public List<Cliente> listarCliente() {
		return clienteService.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> obtenerPorId(@PathVariable Integer id) {
		try {
			Cliente cliente = clienteService.obtenerCliente(id);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		} catch (Exception excepcion) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/guardar")
	public void guardarCliente(Cliente cliente) {
		clienteService.guardarCliente(cliente);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualizarCliente(@RequestBody Cliente cliente, @PathVariable Integer id) {
		try {
			Cliente clienteExistente = clienteService.obtenerCliente(id);

			clienteExistente.setNombre(cliente.getNombre());
			clienteExistente.setSaldo(cliente.getSaldo());
			clienteExistente.setStatus(cliente.getStatus());
			clienteExistente.setTelefono(cliente.getTelefono());
			clienteExistente.setDireccion(cliente.getDireccion());

			clienteService.guardarCliente(clienteExistente);
			return new ResponseEntity<Cliente>(clienteExistente, HttpStatus.OK);
		} catch (Exception excepcion) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminarCliente(@PathVariable Integer id) {
		clienteService.eliminarCliente(id);
	}

}
