package com.nico.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySql implements Conexion {

	private Connection conexion;
	private String url;
	private String user;
	private String password;

	public ConexionMySql(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public void conectar() throws SQLException {
		try {
			conexion = DriverManager.getConnection(url, user, password);
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
