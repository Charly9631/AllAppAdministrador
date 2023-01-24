package com.app.all.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.all.model.Abono;
import com.app.all.repository.AbonoRepository;

@Service
public class AbonoService {

	@Autowired
	public AbonoRepository abonoRepository;

	public List<Abono> listar() {
		return abonoRepository.findAll();
	}

	public void guardarAbono(Abono abono) {
		abonoRepository.save(abono);
	}

	public Abono obtenerAbono(Integer id) {
		return abonoRepository.findById(id).get();
	}

	public void eliminarAbono(Integer id) {
		abonoRepository.deleteById(id);
	}
}
