package com.java.prueba.JBRest.Models;

import java.util.List;

import com.java.prueba.JBRest.Controller.*;
import com.java.prueba.JBRest.Models.*;

public class Asignatura {

	private String nombre;

	private Profesor profesor;

	private Curso curso;

	private List<Estudiante> estudiante;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Estudiante> getEstudiante() {
		try {
			LogicaAsignatura lAsignatura = new LogicaAsignatura();
			return lAsignatura.getEstudiantes(this.profesor.getNombre(), this.nombre, this.curso.getGrado(),
					this.curso.getSalon());
		} catch (Exception e) {
			System.out.println("Error en la ejecuci�n:" + e.getMessage());
			return null;
		}
	}

	public void setEstudiante(List<Estudiante> estudiante) {
		this.estudiante = estudiante;
	}

}
