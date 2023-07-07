package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ModificaBBDD {

	public static void main(String[] args) {
		try {
			// 1. CREAR CONEXION
			String url = "jdbc:mysql://localhost:3306/pruebas";
			String user = "root";
			String password = "root";
			Connection miConexion = DriverManager.getConnection(url, user, password);

			// 2. CREAR OBJETO STATEMENT
			Statement miStatement = miConexion.createStatement();
			String query = "INSERT INTO productos(CÓDIGO_ARTÍCULO, NOMBRE_ARTÍCULO, PRECIO) VALUES('AR77', 'Pantalón', 25.35)";
			String query2 = "UPDATE productos SET PRECIO=PRECIO*2 WHERE CÓDIGO_ARTÍCULO='AR77'";
			String query3 = "DELETE FROM productos WHERE CÓDIGO_ARTÍCULO='AR77'";

			miStatement.executeUpdate(query);
			System.out.println("Datos insertados correctamente");

			miStatement.executeUpdate(query2);
			System.out.println("Datos modificados correctamente");

//			miStatement.executeUpdate(query3);
//			System.out.println("Datos eliminados correctamente");

		} catch (Exception e) {
			System.out.println("NO CONECTA!");
			System.out.println(e);
		}
	}

}
