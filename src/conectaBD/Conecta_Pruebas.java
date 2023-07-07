package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conecta_Pruebas {

	public static void main(String[] args) {
		try {
			// 1. CREAR CONEXION
			String url = "jdbc:mysql://localhost:3306/pruebas";
			String user = "root";
			String password = "root";
			Connection miConexion = DriverManager.getConnection(url, user, password);

			// 2. CREAR OBJETO STATEMENT
			Statement miStatement = miConexion.createStatement();

			// 3. EJECUTAR SQL
			String query = "SELECT * FROM productos";
			ResultSet miResultSet = miStatement.executeQuery(query);

			// 4. RECORRER EL RESULTSET
			String codigoArticulo;
			String nombreArticulo;
			String precio;

			while (miResultSet.next()) {
				codigoArticulo = miResultSet.getString("CÓDIGO_ARTÍCULO");
				nombreArticulo = miResultSet.getString("NOMBRE_ARTÍCULO");
				precio = miResultSet.getString("PRECIO");
				System.out.println(codigoArticulo + " - " + nombreArticulo + " - " + precio);
			}
			miResultSet.close();
		} catch (Exception e) {
			System.out.println("NO CONECTA!");
			System.out.println(e);
		}
	}

}
