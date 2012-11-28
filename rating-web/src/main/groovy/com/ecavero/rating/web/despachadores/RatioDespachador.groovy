package com.ecavero.rating.web.despachadores

static def obtenerRatio(conn, genero, nivel, elemento, edadMin, edadMax) {
	def sql = """
	select sum(ratio) as ratio
	from Rating
	where idGenero = :genero
	and idNivel = :nivel
	and idElemento = :elemento
	and edadMin >= :edadMin
	and edadMax <= :edadMax
	"""
	if (edadMin == null) edadMin = 0
	if (edadMax == null) edadMax = 999
	def filas = conn.rows sql, [genero: genero, nivel: nivel, elemento: elemento, edadMin: edadMin, edadMax: edadMax]
	def ratio = 0
	filas.each {
		ratio = it.ratio
	}
	return ratio
}
