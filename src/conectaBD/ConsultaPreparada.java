package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultaPreparada {

	public static void main(String[] args) {
		try {
			// 1. CREAR CONEXION
			String url = "jdbc:mysql://localhost:3306/pruebas";
			String user = "root";
			String password = "root";
			Connection miConexion = DriverManager.getConnection(url, user, password);

			// 2. PREPARAR CONSULTA
			String query = "SELECT NOMBRE_ARTÍCULO, SECCIÓN, PAÍS_DE_ORIGEN FROM productos WHERE SECCIÓN=? AND PAÍS_DE_ORIGEN=?";
			PreparedStatement miSentencia = miConexion.prepareStatement(query);

			// 3. ESTABLECER PARÁMETROS DE CONSULTA
			String seccion = "DEPORTE";
			String pais = "Usa";
			miSentencia.setString(1, seccion);
			miSentencia.setString(2, pais);

			// 4. EJECUTAR Y RECORRER CONSULTA
			ResultSet rs = miSentencia.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}

			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
