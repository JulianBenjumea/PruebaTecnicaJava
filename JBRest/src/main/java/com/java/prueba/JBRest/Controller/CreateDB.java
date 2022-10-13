package com.java.prueba.JBRest.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

	public Connection conectar() {
		try {
			String jdbURL = "jdbc:derby:memory:ColegioDB";
			Connection conect = DriverManager.getConnection(jdbURL);
			return conect;
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuci�n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		return null;

	}
	public void insertarDB() {
		
		try
		{
		Connection conect = conectar();
		
		Statement carga = conect.createStatement();
		carga.addBatch("INSERT INTO colegio VALUES (1,'El colegio del Olimpo')");

		carga.addBatch("INSERT INTO curso VALUES (1,10,'A',1)");
		carga.addBatch("INSERT INTO curso VALUES (2,10,'B',1)");
		carga.addBatch("INSERT INTO curso VALUES (3,11,'A',1)");
		carga.addBatch("INSERT INTO curso VALUES (4,11,'B',1)");

		carga.addBatch("INSERT INTO estudiante VALUES (1,'Afrodita')");
		carga.addBatch("INSERT INTO estudiante VALUES (2,'Apolo')");
		carga.addBatch("INSERT INTO estudiante VALUES (3,'Ares')");
		carga.addBatch("INSERT INTO estudiante VALUES (4,'Artemisa')");
		carga.addBatch("INSERT INTO estudiante VALUES (5,'Atenea')");
		carga.addBatch("INSERT INTO estudiante VALUES (6,'Dionisio')");
		carga.addBatch("INSERT INTO estudiante VALUES (7,'Hefesto')");
		carga.addBatch("INSERT INTO estudiante VALUES (8,'Hera')");
		carga.addBatch("INSERT INTO estudiante VALUES (9,'Hermes')");
		carga.addBatch("INSERT INTO estudiante VALUES (10,'Hades')");
		carga.addBatch("INSERT INTO estudiante VALUES (11,'Poseidon')");
		carga.addBatch("INSERT INTO estudiante VALUES (12,'Zeus')");

		carga.addBatch("INSERT INTO profesor VALUES (1,'Nemesis')");
		carga.addBatch("INSERT INTO profesor VALUES (2,'Priapo')");
		carga.addBatch("INSERT INTO profesor VALUES (3,'Iris')");

		carga.addBatch("INSERT INTO Asignatura VALUES (1,'Matematicas',1,1,1)");
		carga.addBatch("INSERT INTO Asignatura VALUES (2,'Matematicas',1,2,1)");
		carga.addBatch("INSERT INTO Asignatura VALUES (3,'Matematicas',1,3,1)");
		carga.addBatch("INSERT INTO Asignatura VALUES (4,'Matematicas',1,4,2)");
		carga.addBatch("INSERT INTO Asignatura VALUES (5,'Matematicas',1,5,2)");
		carga.addBatch("INSERT INTO Asignatura VALUES (6,'Matematicas',1,6,2)");
		carga.addBatch("INSERT INTO Asignatura VALUES (7,'Matematicas',1,7,3)");
		carga.addBatch("INSERT INTO Asignatura VALUES (8,'Matematicas',1,8,3)");
		carga.addBatch("INSERT INTO Asignatura VALUES (9,'Matematicas',1,9,4)");
		carga.addBatch("INSERT INTO Asignatura VALUES (10,'Matematicas',1,10,4)");
		carga.addBatch("INSERT INTO Asignatura VALUES (11,'Matematicas',1,11,4)");
		carga.addBatch("INSERT INTO Asignatura VALUES (12,'Matematicas',1,12,4)");
		carga.addBatch("INSERT INTO Asignatura VALUES (13,'Español',2,1,1)");
		carga.addBatch("INSERT INTO Asignatura VALUES (14,'Español',2,2,1)");
		carga.addBatch("INSERT INTO Asignatura VALUES (15,'Español',2,3,1)");
		carga.addBatch("INSERT INTO Asignatura VALUES (16,'Español',2,4,2)");
		carga.addBatch("INSERT INTO Asignatura VALUES (17,'Español',2,5,2)");
		carga.addBatch("INSERT INTO Asignatura VALUES (18,'Español',2,6,2)");
		carga.addBatch("INSERT INTO Asignatura VALUES (19,'Ingles basico',3,1,1)");
		carga.addBatch("INSERT INTO Asignatura VALUES (20,'Ingles basico',3,2,1)");
		carga.addBatch("INSERT INTO Asignatura VALUES (21,'Ingles basico',3,3,1)");
		carga.addBatch("INSERT INTO Asignatura VALUES (22,'Ingles avanzado',3,4,2)");
		carga.addBatch("INSERT INTO Asignatura VALUES (23,'Ingles avanzado',3,5,2)");
		carga.addBatch("INSERT INTO Asignatura VALUES (24,'Ingles avanzado',3,6,2)");
		carga.addBatch("INSERT INTO Asignatura VALUES (25,'Pre Icfe',1,7,3)");
		carga.addBatch("INSERT INTO Asignatura VALUES (26,'Pre Icfe',1,8,3)");
		carga.addBatch("INSERT INTO Asignatura VALUES (27,'Pre Icfe',1,9,4)");
		carga.addBatch("INSERT INTO Asignatura VALUES (28,'Pre Icfe',1,10,4)");
		carga.addBatch("INSERT INTO Asignatura VALUES (29,'Pre Icfe',1,11,4)");
		carga.addBatch("INSERT INTO Asignatura VALUES (30,'Pre Icfe',1,12,4)");

		carga.executeBatch();
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void CreateDB() {

		String jdbURL = "jdbc:derby:memory:ColegioDB;create=true";

		try {
			Connection conect = DriverManager.getConnection(jdbURL);
			System.out.println("Database Created");

			String TablaColegio = "CREATE TABLE colegio (colegioID int primary key, nombre varchar(50) not null)";
			PreparedStatement tabla = conect.prepareStatement(TablaColegio);
			tabla.execute();

			String TablaCurso = "CREATE TABLE curso (cursoID int primary key, grado int not null, salon varchar(50) not null,"
					+ "ColegioID int not null references colegio(colegioID))";
			tabla = conect.prepareStatement(TablaCurso);
			tabla.execute();

			String TablaProfesor = "CREATE TABLE profesor (profesorID int primary key, nombre varchar(100) not null)";
			tabla = conect.prepareStatement(TablaProfesor);
			tabla.execute();

			String TablaEstudiante = "CREATE TABLE estudiante (estudianteID int primary key, nombre varchar(100) not null)";
			tabla = conect.prepareStatement(TablaEstudiante);
			tabla.execute();

			String TablaAsignatura = "CREATE TABLE Asignatura (asignaturaID int primary key, nombre varchar(50) not null,"
					+ "profesorID int not null references profesor(profesorID),"
					+ "estudianteID int not null references estudiante(estudianteID),"
					+ "cursoID int not null references curso(cursoID))";
			tabla = conect.prepareStatement(TablaAsignatura);
			tabla.execute();

			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
