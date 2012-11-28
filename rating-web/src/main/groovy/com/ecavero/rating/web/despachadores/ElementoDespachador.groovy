package com.ecavero.rating.web.despachadores

static def obtenerElementos(conn) {
	def sql = """
	select idElemento, descripcion
	from Elemento
	"""
	def filas = conn.rows sql
	return filas
}
