package com.nico.main;

import java.sql.Date;

import com.nico.dao.ProductoDAO;
import com.nico.dao.ProductoDAOImpl;
import com.nico.modelo.Producto;

public class Main {

	public static void main(String[] args) {
		Producto p = new Producto();
		p.setCodigo("AR98");
		p.setNombre("Nombre de prueba");
		p.setPrecio(99.999);
		p.setFecha(new Date(System.currentTimeMillis()));
		p.setPaisOrigen("Brasil");

		try {
			ProductoDAO dao = new ProductoDAOImpl();
			for (Producto pr: dao.listar())
				System.out.println(pr);
			System.out.println("Consulta completa!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
