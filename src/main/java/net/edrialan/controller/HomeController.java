package net.edrialan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import net.edrialan.model.Vacante;

import org.springframework.ui.Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model)
	{
		List<Vacante> lista= getVacantes();
		model.addAttribute("vacantes", lista);
		
		return"detalle";
	}
	
	@GetMapping("/")
	public String mostrarHome(Model model) 
	{
		//model.addAttribute("mensaje", "Bienvenidos a Empleos APP");
		//model.addAttribute("fecha", new Date());
		
		
		String nombre = "Auxilair de contabilidad";
		Date fechaPub = new Date();
		double salario = 9000.00;
		boolean vigente = true;
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("fechaPub", fechaPub);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);
		
		
		return "home";
		
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) 
	{
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero de sistemas");
		lista.add("auxilair de contabilidad");
		lista.add("vendedor");
		lista.add("arquitecto");
		
		model.addAttribute("empleos", lista);
		
		return "listado";
	}
	
	private List<Vacante> getVacantes()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Vacante> lista = new LinkedList<Vacante>();
		
		try 
		{
			Vacante vacante1 = new Vacante();
			
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero de comunicaciones");
			vacante1.setDescripcion("Se solicita ing para dar soporte a intranet");
			vacante1.setFecha(sdf.parse("08-02-2021"));
			vacante1.setDestacado(1);
			vacante1.setSalario(9700.00);
			
			lista.add(vacante1);
			
			
			Vacante vacante2 = new Vacante();
			
			vacante2.setId(2);
			vacante2.setNombre("Contador");
			vacante2.setDescripcion("Hacer cosas de contadores");
			vacante2.setFecha(sdf.parse("08-02-2021"));
			vacante2.setDestacado(0);
			vacante2.setSalario(500.00);
			
			lista.add(vacante2);
			
			Vacante vacante3 = new Vacante();
			
			vacante3.setId(2);
			vacante3.setNombre("Conserje");
			vacante3.setDescripcion("Limpiar cosas feas");
			vacante3.setFecha(sdf.parse("02-02-2021"));
			vacante3.setDestacado(1);
			vacante3.setSalario(200.00);
			
			lista.add(vacante3);
			
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
}
