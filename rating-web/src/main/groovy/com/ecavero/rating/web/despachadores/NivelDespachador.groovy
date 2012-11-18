package com.ecavero.rating.web.despachadores

static def obtenerNiveles(conn) {
	def sql = """
	select idNivel, descripcion
	from Nivel
	"""
	def filas = conn.rows sql
	return filas
}
