package com.ecavero.rating.web.despachadores

static def obtenerEdades(conn) {
	def sql = """
	select distinct edadMin, edadMax
	from Rating
	"""
	def filas = conn.rows sql
	return filas
}
