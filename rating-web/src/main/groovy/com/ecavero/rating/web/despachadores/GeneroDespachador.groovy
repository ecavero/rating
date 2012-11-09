package com.ecavero.rating.web.despachadores


static def obtenerGeneros(conn) {
	def sql = """
	select idGenero, descripcion
	from Genero
	"""
	def filas = conn.rows sql
	return filas
}


