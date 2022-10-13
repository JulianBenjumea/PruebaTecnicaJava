package com.java.prueba.JBRest.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.*;

import com.java.prueba.JBRest.Models.*;

public class LogicaCurso {
	
	public boolean ActualizarCurso(Curso curso)
	{
		try {
			Connection conect = new CreateDB().conectar();
			Statement carga = conect.createStatement();
			carga.addBatch("UPDATE curso SET grado = "+curso.getGrado()+", salon = '"+curso.getSalon()+"' WHERE CursoID = "+curso.getCursoID()+" " );
			carga.executeBatch();
			return true;
		}
		catch (SQLException sqle) {
			System.out.println("Error en la ejecuci�n:" + sqle.getErrorCode() + " " + sqle.getMessage());
			return false;
		}
	}
	public boolean EliminarCurso(Curso curso)
	{
		try {
			Connection conect = new CreateDB().conectar();
			Statement carga = conect.createStatement();
			carga.addBatch("DELETE FROM curso WHERE CursoID ="+curso.getCursoID()+" ");
			carga.executeBatch();			
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	public boolean RegistrarCurso(Curso curso)
	{
		try {
			Connection conect = new CreateDB().conectar();
			Integer ID = ValorIDCurso();
			Statement carga = conect.createStatement();
			carga.addBatch("INSERT INTO curso VALUES ("+(ID + 1)+","+curso.getGrado()+",'"+curso.getSalon()+"',1)");
			System.out.println("INSERT INTO curso VALUES ("+(ID + 1)+","+curso.getGrado()+",'"+curso.getSalon()+"',1)");
			carga.executeBatch();
			
			return true;
		}
		catch (SQLException sqle) {
			System.out.println("Error en la ejecuci�n:" + sqle.getErrorCode() + " " + sqle.getMessage());
			return false;
		}
	}
	
	public List<Curso> ListarCursos()
	{
		try {
			List<Curso> cursos = new ArrayList<Curso>();
			
			Connection conect = new CreateDB().conectar();
			PreparedStatement stmt = conect.prepareStatement("SELECT * FROM curso");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Curso curso = new Curso();
				curso.setCursoID(Integer.parseInt(rs.getString("CursoID")));
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
	
	private int ValorIDCurso()
	{
		try {			
			List<Curso> IDcurso = ListarCursos();
			System.out.println("CURSOID:"+ IDcurso.get(IDcurso.size() - 1).getCursoID());
			return IDcurso.get(IDcurso.size() - 1).getCursoID();
		} catch (Exception sqle) {
			System.out.println("Error en la ejecuci�n:" + sqle.getMessage());
		}
		return 0;
	}

	public Curso getCurso(Integer grado, String salon)
	{
		try {
			Curso curso = new Curso();
			
			Connection conect = new CreateDB().conectar();
			PreparedStatement stmt = conect.prepareStatement("SELECT cur.grado,cur.salon,col.nombre FROM curso cur inner join colegio col on col.colegioID = cur.colegioID where cur.grado = "+grado+" and cur.salon ='"+salon+ "'");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				curso.setGrado(Integer.parseInt(rs.getString("grado")));
				curso.setSalon(rs.getString("salon"));
				Colegio colegio = new Colegio();
				colegio.setNombre(rs.getString("nombre"));
				curso.setColegio(colegio);
			}
			return curso;

		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuci�n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		return null;
	}
	public Curso getCursobyID(Integer cursoID)
	{
		try {
			Curso curso = new Curso();
			
			Connection conect = new CreateDB().conectar();
			PreparedStatement stmt = conect.prepareStatement("SELECT cur.grado,cur.salon FROM curso cur where cur.cursoID = "+cursoID+" ");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				curso.setGrado(Integer.parseInt(rs.getString("grado")));
				curso.setSalon(rs.getString("salon"));
				Colegio colegio = new Colegio();
				colegio.setNombre(rs.getString("nombre"));
				curso.setColegio(colegio);
			}
			return curso;

		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuci�n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		return null;
	}
	public List<Asignatura> getAsignaturasByCurso(Integer grado, String salon){
		try {
			List<Asignatura> asignatiuras = new ArrayList<Asignatura>();
			
			Connection conect = new CreateDB().conectar();
			PreparedStatement stmt = conect.prepareStatement("SELECT DISTINCT a.nombre as nombreAsignatura,p.nombre as Profesor,cur.grado,cur.salon FROM asignatura a inner join curso cur on cur.cursoID = a.cursoID"+
			" inner join profesor p on p.profesorID = a.profesorID where cur.grado = "+grado+" and cur.salon ='"+salon+"' ");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Asignatura asignatura = new Asignatura();
				asignatura.setNombre(rs.getString("nombreAsignatura"));
				Profesor profesor = new Profesor();			
				profesor.setNombre(rs.getString("Profesor"));
				asignatura.setProfesor(profesor);
				Curso curso = new Curso();
				curso.setGrado(Integer.parseInt(rs.getString("grado")));
				curso.setSalon(rs.getString("salon"));
				asignatura.setCurso(curso);
				asignatiuras.add(asignatura);
			}
			return asignatiuras;

		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuci�n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		return null;
	}
}
