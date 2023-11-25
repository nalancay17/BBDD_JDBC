package com.nico.dao;

import java.util.List;

import com.nico.modelo.Producto;

public interface ProductoDAO {

	public void registrar(Producto p) throws Exception;

	public void modificar(Producto p) throws Exception;

	public void eliminar(Producto p) throws Exception;

	public List<Producto> listar() throws Exception;

	public Producto getProducto(String codigo) throws Exception;
}
