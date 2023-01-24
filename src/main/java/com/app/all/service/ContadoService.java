package com.app.all.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.all.model.Contado;
import com.app.all.repository.ContadoRepository;

@Service
public class ContadoService {

	@Autowired
	public ContadoRepository contadoRepository;

	public List<Contado> listar() {
		return contadoRepository.findAll();
	}

	public void guardarContado(Contado contado) {
		contadoRepository.save(contado);
	}

	public Contado obtenerContado(Integer id) {
		return contadoRepository.findById(id).get();
	}

	public void eliminarContado(Integer id) {
		contadoRepository.deleteById(id);
	}
}
