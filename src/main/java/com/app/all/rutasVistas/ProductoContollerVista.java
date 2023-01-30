package com.app.all.rutasVistas;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.all.model.Producto;
import com.app.all.service.ProductoService;


@Controller
@RequestMapping("/productoV")
public class ProductoContollerVista {
	
	private final Logger LOGGER = LoggerFactory.getLogger(Producto.class);
	
	@Autowired
	private ProductoService productoService;

	@GetMapping("")
	public String productos(Model model) {
		model.addAttribute("productos", productoService.listar());
		return "productos";
	}
	
	@GetMapping("/crear")
	public String crear() {
		return "crearProducto";
	}
	
	@PostMapping("/guardar")
	public String guardar(Producto producto) {
		LOGGER.info("Este es un objeto producto {}", producto);
		productoService.Guardar(producto);
		return "redirect:/productoV";
	}
	
}
