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

import com.app.all.model.Producto;
import com.app.all.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	public ProductoService productoService;

	@GetMapping("")
	public List<Producto> listarProducto() {
		return productoService.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Producto> obtenerPorId(@PathVariable Integer id) {
		try {
			Producto producto = productoService.obtenerPorId(id);
			return new ResponseEntity<Producto>(producto, HttpStatus.OK);

		} catch (Exception exception) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/guardar")
	public void guardarProducto(Producto producto) {
		productoService.Guardar(producto);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto, @PathVariable Integer id) {
		try {
			Producto productoExistente = productoService.obtenerPorId(id);
			productoExistente.setCodigo(producto.getCodigo());
			productoExistente.setNombre(producto.getNombre());
			productoExistente.setPrecio(producto.getPrecio());
			productoExistente.setPropiedades(producto.getPropiedades());
			productoExistente.setStock(producto.getStock());

			productoService.Guardar(productoExistente);
			return new ResponseEntity<Producto>(productoExistente, HttpStatus.OK);
		} catch (Exception excepcion) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("eliminar/{id}")
	public void eliminarProducto(@PathVariable Integer id) {
		productoService.eliminarProducto(id);
	}
}
