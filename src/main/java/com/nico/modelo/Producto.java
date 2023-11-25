package com.nico.modelo;

import java.math.BigDecimal;
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
		if (codigo == null)
			throw new IllegalArgumentException("El código no puede ser nulo");
		if (codigo.length() < 4 || codigo.length() > 10)
			throw new IllegalArgumentException("El código debe tener entre 4 y 10 caracteres");
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null)
			throw new IllegalArgumentException("El nombre no puede ser nulo");
		if (nombre.length() < 3 || nombre.length() > 70)
			throw new IllegalArgumentException("El nombre debe tener entre 3 y 70 caracteres");
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		double limite = 99999999.99;
		if (precio < 0)
			throw new IllegalArgumentException("El precio no puede ser negativo");
	    if (tieneMasDe2Decimales(precio))
	        throw new IllegalArgumentException("El precio no puede tener más de 2 decimales");
	    if (precio > limite)
			throw new IllegalArgumentException("El precio debe ser menor o igual a " + limite);
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
		if (paisOrigen == null)
			throw new IllegalArgumentException("El país de origen no puede ser nulo");
		if (paisOrigen.length() < 3 || paisOrigen.length() > 70)
			throw new IllegalArgumentException("El país de origen debe tener entre 3 y 70 caracteres");
		this.paisOrigen = paisOrigen;
	}

	@Override
	public String toString() {
		return "Producto [" + codigo + " | " + nombre + " | " + precio + " | " + fecha
				+ " | " + paisOrigen + "]";
	}

	private boolean tieneMasDe2Decimales(double precio) {
		BigDecimal precioBigDecimal = BigDecimal.valueOf(precio);
	    BigDecimal decimales = precioBigDecimal.subtract(new BigDecimal(precioBigDecimal.toBigInteger()));
	    int cantDecimales = decimales.scale();
	    return cantDecimales > 2;
	}

}
