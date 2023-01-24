package com.app.all.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.all.model.Administrador;
import com.app.all.repository.AdministradorRepository;

@Service
public class AdministradorService {

	@Autowired
	public AdministradorRepository administradorRepository;

	public List<Administrador> listar() {
		return administradorRepository.findAll();
	}

	public void guardarAdministrador(Administrador administrador) {
		administradorRepository.save(administrador);
	}

	public Administrador obtenerAdministrador(Integer id) {
		return administradorRepository.findById(id).get();
	}

	public void eliminarAdministrador(Integer id) {
		administradorRepository.deleteById(id);
	}
}
