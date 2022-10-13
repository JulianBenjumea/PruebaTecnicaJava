package com.java.prueba.JBRest.Models;

import java.util.List;

public class VistaAsignaturasProfesor {
	
	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	public String getNombreProfesor() {
		return nombreProfesor;
	}

	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public List<Estudiante> getEstudiantes() {
		return Estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		Estudiantes = estudiantes;
	}

	private String nombreAsignatura;
	
	private String nombreProfesor;
	
	private String curso;
	
	private List<Estudiante> Estudiantes;
}
