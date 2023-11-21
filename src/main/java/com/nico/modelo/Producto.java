package com.nico.modelo;

import java.sql.Date;

public class Producto {

	private String codigo;
	private String nombre;
	private double precio;
	private Date fecha;
	private String paisOrigen;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	@Override
	public String toString() {
		return "Producto [" + codigo + " | " + nombre + " | " + precio + " | " + fecha
				+ " | " + paisOrigen + "]";
	}

}
