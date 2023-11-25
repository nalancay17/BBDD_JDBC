package com.nico.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ProductoTest {

	private Producto p;

	@Before
	public void setup() {
		p = new Producto();
	}

	@Test(expected = IllegalArgumentException.class)
	public void codigoNullTest() {
		p.setCodigo(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void codigoTamanioMenor5Test() {
		String codigo = "abc";
		p.setCodigo(codigo);
	}

	@Test(expected = IllegalArgumentException.class)
	public void codigoTamanioMayor10Test() {
		String codigo = "abcdefghijk";
		p.setCodigo(codigo);
	}

	@Test
	public void codigo5CharOkTest() {
		String codigo5Char = "AR510";
		p.setCodigo(codigo5Char);
		assertEquals(codigo5Char, p.getCodigo());
		assertEquals(5, p.getCodigo().length());
	}

	@Test
	public void codigo10CharOkTest() {
		String codigo10Char = "AR12345678";
		p.setCodigo(codigo10Char);
		assertEquals(codigo10Char, p.getCodigo());
		assertEquals(10, p.getCodigo().length());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nombreNullTest() {
		p.setNombre(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nombreTamanioMenor3Test() {
		String nombre = "al";
		p.setNombre(nombre);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nombreTamanioMayor70Test() {
		String nombre = "1234567891012345678910123456789101234567891012345678910123456789101234567891012345678910123456789101234567891012345678910";
		p.setNombre(nombre);
	}

	@Test
	public void nombre3CharOkTest() {
		String nombre = "abc";
		p.setNombre(nombre);
		assertEquals(nombre, p.getNombre());
		assertEquals(3, p.getNombre().length());
	}

	@Test
	public void nombre70CharOkTest() {
		String nombre = "qwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiop";
		p.setNombre(nombre);
		assertEquals(nombre, p.getNombre());
		assertEquals(70, p.getNombre().length());
	}

	@Test(expected = IllegalArgumentException.class)
	public void precioNegativoTest() {
		double precio = -10.00;
		p.setPrecio(precio);
	}

	@Test(expected = IllegalArgumentException.class)
	public void precioMasDe2DecimalesTest() {
		double precio = 10.003;
		p.setPrecio(precio);
	}

	@Test(expected = IllegalArgumentException.class)
	public void precioMayor8DigitosTest() {
		double precio = 199456789.11;
		p.setPrecio(precio);
	}

	@Test
	public void precio8Digitos2DecimalesOkTest() {
		double precio = 12345678.91;
		p.setPrecio(precio);
		assertEquals(precio, p.getPrecio(), 0.000000001);
	}

	@Test
	public void precio8Digitos1DecimalOkTest() {
		double precio = 12345678.9;
		p.setPrecio(precio);
		assertEquals(precio, p.getPrecio(), 0.000000001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void paisOrigenNullTest() {
		p.setPaisOrigen(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void paisOrigenTamanioMenor3Test() {
		String paisOrigen = "ab";
		p.setPaisOrigen(paisOrigen);
	}

	@Test(expected = IllegalArgumentException.class)
	public void paisOrigenTamanioMayor70Test() {
		String paisOrigen = "qwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiop";
		p.setPaisOrigen(paisOrigen);
	}

	@Test
	public void paisOrigen3CharOkTest() {
		String paisOrigen = "eua";
		p.setPaisOrigen(paisOrigen);
		assertEquals(paisOrigen, p.getPaisOrigen());
		assertEquals(3, p.getPaisOrigen().length());
	}

	@Test
	public void paisOrigen70CharOkTest() {
		String paisOrigen = "qwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiop";
		p.setPaisOrigen(paisOrigen);
		assertEquals(paisOrigen, p.getPaisOrigen());
		assertEquals(70, p.getPaisOrigen().length());
	}

}
