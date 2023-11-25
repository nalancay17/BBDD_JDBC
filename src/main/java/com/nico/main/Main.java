package com.nico.main;

import java.sql.Date;

import com.nico.dao.Conexion;
import com.nico.dao.ConexionMySql;
import com.nico.dao.ProductoDAO;
import com.nico.dao.ProductoDAOImpl;
import com.nico.modelo.Producto;

public class Main {

	private static final String URL = "jdbc:mysql://localhost:3306/bbdd_jdbc";
	private static final String USER = "root";
	private static final String PASSWORD = "manager1";

	public static void main(String[] args) {
		Producto p = new Producto();
		p.setCodigo("AR101");
		p.setNombre("OTRA PRUEBA");
		p.setPrecio(77.8);
		p.setFecha(new Date(System.currentTimeMillis()));
		p.setPaisOrigen("Argentina");

		try {
			Conexion conexion = new ConexionMySql(URL, USER, PASSWORD);
			ProductoDAO dao = new ProductoDAOImpl(conexion);
			for (Producto pr: dao.listar())
				System.out.println(pr);
			System.out.println("Consulta completa!");
			conexion.cerrar();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
