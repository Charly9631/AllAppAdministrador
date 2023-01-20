package com.app.all.service;

import java.util.Optional;

import com.app.all.model.Producto;

public interface ProductoService {
	
	public Producto save(Producto producto);
	public Optional<Producto> get(Integer id);
	public void Update(Producto producto);
	public void Delete(Integer id);
	
}
