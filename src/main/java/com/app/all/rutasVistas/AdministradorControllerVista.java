package com.app.all.rutasVistas;

import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.all.model.Administrador;

@Controller
@RequestMapping("/administradorV")
public class AdministradorControllerVista {


	
	private final Logger LOGGER = LoggerFactory.getLogger(Administrador.class);
	
	@GetMapping("")
	public String login() {
		return "loginA";
	}
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@PostMapping("/logear")
	public String logear(Administrador user) {
		LOGGER.info("Este es el administrador {}", user);
		return "redirect:/administradorV/menu";
	}
}
