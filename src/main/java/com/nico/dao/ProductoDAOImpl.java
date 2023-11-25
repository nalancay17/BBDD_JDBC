package com.nico.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nico.modelo.Producto;

public class ProductoDAOImpl implements ProductoDAO {

	private Conexion conexion;
	private static final String INSERT = "INSERT INTO producto (codigo, nombre, precio, fecha, pais_origen) VALUES(?,?,?,?,?)";
	private static final String UPDATE = "UPDATE producto SET nombre = ?, precio = ?, fecha = ?, pais_origen = ? WHERE codigo = ?";
	private static final String DELETE = "DELETE FROM producto WHERE codigo = ?";
	private static final String SELECT = "SELECT * from producto";
	private static final String SELECT_ONE = "SELECT * FROM producto WHERE codigo = ?";

	public ProductoDAOImpl(Conexion conexion) {
		this.conexion = conexion;
	}

	@Override
	public void registrar(Producto p) throws Exception {
		try {
			conexion.conectar();
			PreparedStatement st = conexion.getConexion().prepareStatement(INSERT);
			st.setString(1, p.getCodigo());
			st.setString(2, p.getNombre());
			st.setDouble(3, p.getPrecio());
			st.setDate(4, p.getFecha());
			st.setString(5, p.getPaisOrigen());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			conexion.cerrar();
		}
	}

	@Override
	public void modificar(Producto p) throws Exception {
		try {
			conexion.conectar();
			PreparedStatement st = conexion.getConexion().prepareStatement(UPDATE);
			st.setString(1, p.getNombre());
			st.setDouble(2, p.getPrecio());
			st.setDate(3, p.getFecha());
			st.setString(4, p.getPaisOrigen());
			st.setString(5, p.getCodigo());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			conexion.cerrar();
		}
	}

	@Override
	public void eliminar(Producto p) throws Exception {
		try {
			conexion.conectar();
			PreparedStatement st = conexion.getConexion().prepareStatement(DELETE);
			st.setString(1, p.getCodigo());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			conexion.cerrar();
		}
	}

	@Override
	public List<Producto> listar() throws Exception {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		try {
			conexion.conectar();
			Statement st = conexion.getConexion().createStatement();
			ResultSet rs = st.executeQuery(SELECT);

			while (rs.next()) {
				Producto p = new Producto();
				p.setCodigo(rs.getString("codigo"));
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getDouble("precio"));
				p.setFecha(rs.getDate("fecha"));
				p.setPaisOrigen(rs.getString("pais_origen"));

				lista.add(p);
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			conexion.cerrar();
		}
		return lista;
	}

	@Override
	public Producto getProducto(String codigo) throws Exception {
		try {
			conexion.conectar();
			PreparedStatement st = conexion.getConexion().prepareStatement(SELECT_ONE);
			st.setString(1, codigo);
			ResultSet rs = st.executeQuery();

			Producto p = null;
			if (rs.next())
				p = obtenerProductoDelResultSet(rs);
			return p;
		} catch (Exception e) {
			throw e;
		} finally {
			conexion.cerrar();
		}
	}

	private Producto obtenerProductoDelResultSet(ResultSet rs) throws SQLException {
		Producto p = new Producto();
		p.setCodigo(rs.getString("codigo"));
		p.setNombre(rs.getString("nombre"));
		p.setPrecio(rs.getDouble("precio"));
		p.setFecha(rs.getDate("fecha"));
		p.setPaisOrigen(rs.getString("pais_origen"));
		return p;
	}

}
