package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private Connection conexion;
	private final String URL = "jdbc:mysql://localhost:3306/pruebas";
	private final String USER = "root";
	private final String PASSWORD = "root";

	public void conectar() throws Exception {
		try {
			conexion = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch(Exception e) {
			throw e;
		}
	}

	public void cerrar() throws SQLException {
		if (conexion != null && !conexion.isClosed())
			conexion.close();
	}

	public Connection getConexion() {
		return this.conexion;
	}
}
