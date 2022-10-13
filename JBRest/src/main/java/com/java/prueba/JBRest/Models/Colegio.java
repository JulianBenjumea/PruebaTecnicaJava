package com.java.prueba.JBRest.Models;

import java.util.List;

import com.java.prueba.JBRest.Controller.*;
import com.java.prueba.JBRest.Models.*;

public class Colegio {
	
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	private List<Curso> cursos;

	public List<Curso> getCursos() {
		LogicaColegio lColegio = new LogicaColegio();
		return lColegio.getCursos(this.nombre);
	}
	
}
