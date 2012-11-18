package com.ecavero.rating.web.pool

import groovy.sql.*
import javax.naming.*

public class ConnectionPool {
	static def obtenerConexion(fuente) {
		def context = new InitialContext()
		def ds = context.lookup("java:comp/env/$fuente")
		def conn = new Sql(ds)
		return conn
	}
	
	static def obtenerConexion() {
		return obtenerConexion("jdbc/prod")
	}
}
