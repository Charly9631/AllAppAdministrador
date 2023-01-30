package com.app.all.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.all.model.Producto;
import com.app.all.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	public ProductoRepository productoRepository;

	public List<Producto> listar() {
		return productoRepository.findAll();
	}

	public Producto obtenerPorId(@PathVariable Integer id) {
		return productoRepository.findById(id).get();
	}

	public void Guardar(Producto producto) {
		productoRepository.save(producto);
	}

	public void eliminarProducto(@PathVariable Integer id) {
		productoRepository.deleteById(id);
	}
	
	public List<Producto> listarPorNombre(String nombre){
		return productoRepository.findByNombreLikeIgnoreCase("%"+nombre+"%");
	}

}
