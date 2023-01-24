package com.app.all.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.all.model.Credito;
import com.app.all.repository.CreditoRepository;

@Service
public class CreditoService {

	@Autowired
	public CreditoRepository creditoRepository;

	public List<Credito> listar() {
		return creditoRepository.findAll();
	}

	public void guardarCredito(Credito credito) {
		creditoRepository.save(credito);
	}

	public Credito obtenerCredito(Integer id) {
		return creditoRepository.findById(id).get();
	}

	public void eliminarCredito(Integer id) {
		creditoRepository.deleteById(id);
	}
}
