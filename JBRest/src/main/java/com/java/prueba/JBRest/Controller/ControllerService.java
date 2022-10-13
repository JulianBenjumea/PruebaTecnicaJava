package com.java.prueba.JBRest.Controller;

import java.util.List;

import com.java.prueba.JBRest.Models.*;

public class ControllerService {

	// Metodo para creación y validación de BD
	public boolean ConnectDatabase() {
		if (new CreateDB().conectar() == null) {
			new CreateDB().CreateDB();
			new CreateDB().insertarDB();
		}
		return true;
	}

	public List<VistaAsignaturasProfesor> getAsignaturasByProfesor(String nombre) {
		System.out.println(nombre);
		LogicaProfesor lprofesor = new LogicaProfesor();
		List<VistaAsignaturasProfesor> asignaturas = lprofesor.getAsignaturasByProfesor(nombre);
		return asignaturas;
	}

	public boolean RegistrarCurso(Curso curso) {
		if (curso.getGrado() > 0 && curso.getSalon() != "") {
			System.out.println(curso);
			LogicaCurso lcurso = new LogicaCurso();
			return lcurso.RegistrarCurso(curso);
		} else
			return false;
	}
	
	public boolean ActualizarCusro(Curso curso) {
		if (curso.getGrado() > 0 && curso.getSalon() != "") {
			System.out.println(curso);
			LogicaCurso lcurso = new LogicaCurso();
			return lcurso.ActualizarCurso(curso);
		} else
			return false;
	}

	public boolean EliminarCurso(Curso curso) {
		if (curso.getCursoID() > 0) {
			System.out.println(curso);
			LogicaCurso lcurso = new LogicaCurso();
			return lcurso.EliminarCurso(curso);
		} else
			return false;
	}
	
	public List<Curso> ConsultarCursos() {
		LogicaCurso lcurso = new LogicaCurso();
		return lcurso.ListarCursos();
	}
}
