package com.java.prueba.JBRest.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.prueba.JBRest.Models.*;

public class LogicaAsignatura {

	public List<Estudiante> getEstudiantes(String profesor,String Asignatura, Integer grado, String salon){
		try {
			List<Estudiante> estudiantes = new ArrayList<Estudiante>();
			
			Connection conect = new CreateDB().conectar();			
			
			PreparedStatement stmt = conect.prepareStatement("SELECT e.nombre FROM asignatura a inner join estudiante e on e.estudianteID = a.estudianteID "+
			"inner join curso c on c.cursoID = a.cursoID inner join profesor p on p.profesorID = a.profesorID "+
			"where p.nombre = '"+profesor+"' and a.nombre = '"+Asignatura+"' and c.grado = "+grado+" and c.salon = '"+salon+"' ");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Estudiante estudiante = new Estudiante();
				estudiante.setNombre(rs.getString("nombre"));
				estudiantes.add(estudiante);
			}
			return estudiantes;

		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuci�n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		return null;
	}
	public List<VistaAsignaturasProfesor> getAsignaturasByProfesor(String nombre)
	{
		System.out.println(nombre);
		LogicaProfesor lprofesor = new LogicaProfesor();
		List<VistaAsignaturasProfesor> asignaturas = lprofesor.getAsignaturasByProfesor(nombre);	
		return asignaturas;
	}

}
