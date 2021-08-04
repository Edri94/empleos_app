package net.edrialan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.util.Date;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		model.addAttribute("mensaje", "Bienvenidos a Empleos APP");
		model.addAttribute("fecha", new Date());
		return "home";
	}
	
}
