package com.java.prueba.JBRest.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.prueba.JBRest.Models.*;

public class LogicaColegio {

	public Colegio getColegio(String nombreColegio)
	{
		try {
			Colegio colegio = new Colegio();
			
			Connection conect = new CreateDB().conectar();
			PreparedStatement stmt = conect.prepareStatement("SELECT col.nombre FROM colegio col where col.nombre ='"+nombreColegio+ "'");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				colegio.setNombre(rs.getString("nombre"));
			}

		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuci�n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		return null;
	}
	public List<Curso> getCursos(String nombreColegio)
	{
		try {
			List<Curso> cursos = new ArrayList<Curso>();
			
			Connection conect = new CreateDB().conectar();
			PreparedStatement stmt = conect.prepareStatement("SELECT cur.grado,cur.salon FROM colegio col inner join curso cur on cur.colegioID = col.colegioID where col.nombre ='"+nombreColegio+ "'");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Curso curso = new Curso();
				curso.setGrado(Integer.parseInt(rs.getString("grado")));
				curso.setSalon(rs.getString("salon"));
				cursos.add(curso);
			}
			return cursos;

		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuci�n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		return null;
	}
}
