package com.java.prueba.JBRest.Models;

import java.util.List;
import com.java.prueba.JBRest.Controller.*;
import com.java.prueba.JBRest.Models.*;

public class Curso {
	private int CursoID;
	
	private int grado;
	public int getGrado() {
		return grado;
	}
	public void setGrado(int grado) {
		this.grado = grado;
	}
	public String getSalon() {
		return salon;
	}
	public void setSalon(String salon) {
		this.salon = salon;
	}
	private String salon;
	
	private Colegio colegio;
	public Colegio getColegio() {
		return colegio;
	}
	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}
	public int getCursoID() {
		return CursoID;
	}
	public void setCursoID(int cursoID) {
		CursoID = cursoID;
	}
	
}
