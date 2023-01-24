package com.app.all.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.all.model.Cliente;
import com.app.all.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	public ClienteRepository clienteRepository;

	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	public void guardarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	public Cliente obtenerCliente(Integer id) {
		return clienteRepository.findById(id).get();
	}

	public void eliminarCliente(Integer id) {
		clienteRepository.deleteById(id);
	}
}
