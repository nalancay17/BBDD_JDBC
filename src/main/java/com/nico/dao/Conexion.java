package com.nico.dao;

import java.sql.Connection;

public interface Conexion {

    void conectar() throws Exception;

    void cerrar() throws Exception;

    Connection getConexion();
}
