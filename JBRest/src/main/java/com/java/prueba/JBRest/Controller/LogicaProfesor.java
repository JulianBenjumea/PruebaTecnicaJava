package com.java.prueba.JBRest.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.prueba.JBRest.Models.*;

public class LogicaProfesor {
	
	
	public Profesor getProfesor(String nombre)
	{
		try {
			Profesor profesor = new Profesor();
			
			Connection conect = new CreateDB().conectar();
			PreparedStatement stmt = conect.prepareStatement("SELECT p.nombre FROM profesor p  where p.nombre = '"+nombre+"'");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				profesor.setNombre(rs.getString("nombre"));
			}
			return profesor;

		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuci�n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		return null;
	}
	public Profesor getProfesorbyID(int profesorID)
	{
		try {
			Profesor profesor = new Profesor();
			
			Connection conect = new CreateDB().conectar();
			PreparedStatement stmt = conect.prepareStatement("SELECT p.nombre FROM profesor p  where p.profesorID = "+profesorID+" ");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				profesor.setNombre(rs.getString("nombre"));
			}
			return profesor;

		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuci�n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		return null;
	}
	
	public List<VistaAsignaturasProfesor> getAsignaturasByProfesor(String nombre){
		try {
			
			if(nombre == null)
				return null;
			
			List<VistaAsignaturasProfesor> asignatiuras = new ArrayList<VistaAsignaturasProfesor>();
			
			Connection conect = new CreateDB().conectar();
			
			
			String sql = "SELECT DISTINCT a.nombre as nombreAsignatura,p.nombre as Profesor,cur.grado,cur.salon FROM asignatura a inner join curso cur on cur.cursoID = a.cursoID"+
					" inner join profesor p on p.profesorID = a.profesorID where p.nombre = '"+nombre+"' ";		
			
			PreparedStatement stmt = conect.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				VistaAsignaturasProfesor asignatura = new VistaAsignaturasProfesor();
				asignatura.setNombreAsignatura(rs.getString("nombreAsignatura"));
				asignatura.setNombreProfesor(rs.getString("Profesor"));
				asignatura.setCurso(rs.getInt("grado")+rs.getString("salon"));
				asignatiuras.add(asignatura);
				String salida = asignatura.getNombreAsignatura()+" "+asignatura.getNombreProfesor()+" "+asignatura.getCurso();
				System.out.println(salida);
				
			}
			return asignatiuras;

		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuci�n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		return null;
	}

}
