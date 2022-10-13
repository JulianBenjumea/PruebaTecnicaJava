package com.java.prueba.JBRest.Service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.prueba.JBRest.Controller.ControllerService;
import com.java.prueba.JBRest.Models.*;


@RestController
@RequestMapping(path = "/servicioREST")
public class Service {

	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json", path = "getAsignaturas")
	public List<VistaAsignaturasProfesor> getAsignaturas(@RequestBody Profesor profesor) {		
		ControllerService Service = new ControllerService();
		Service.ConnectDatabase();		
		return Service.getAsignaturasByProfesor(profesor.getNombre());	
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes =  "application/json"
			, produces = "application/json", path = "RegistrarCurso")
	public boolean RegistrarCurso(@RequestBody Curso curso)
	{
		ControllerService Service = new ControllerService();
		Service.ConnectDatabase();
		return Service.RegistrarCurso(curso);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "ConsultarCursos")
	public List<Curso> ConsultarCursos()
	{
		ControllerService Service = new ControllerService();
		Service.ConnectDatabase();
		return Service.ConsultarCursos();		
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes =  "application/json"
			, produces = "application/json", path = "ActualizarCurso")
	public boolean ActualizarCurso(@RequestBody Curso curso)
	{
		ControllerService Service = new ControllerService();
		Service.ConnectDatabase();
		return Service.ActualizarCusro(curso);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, consumes =  "application/json"
			, produces = "application/json", path = "EliminarCurso")
	public boolean EliminarCurso(@RequestBody Curso curso)
	{
		ControllerService Service = new ControllerService();
		Service.ConnectDatabase();
		return Service.EliminarCurso(curso);
	}
	
}