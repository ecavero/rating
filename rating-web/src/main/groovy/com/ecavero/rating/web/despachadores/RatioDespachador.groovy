package com.ecavero.rating.web.despachadores

static def obtenerRatio(conn, genero, niveles, elemento, edadMin, edadMax) {
	def paramNiveles = []
	niveles.eachWithIndex {
		n, i ->
		paramNiveles << ":nivel$i"
	}
	
	def sql = """
	select sum(ratio) as ratio
	from Rating
	where idGenero = :genero
	and idNivel in (${paramNiveles.join(',')})
	and idElemento = :elemento
	and edadMin = :edadMin
	and edadMax = :edadMax
	"""
	
	def params = [genero: genero, elemento: elemento, edadMin: edadMin, edadMax: edadMax]
	niveles.eachWithIndex {
		n, i ->
		params["nivel$i"] = n
	}
	println "sql : $sql"
	println "params: $params"
	def filas = conn.rows sql, params
	def ratio = 0
	filas.each {
		ratio = it.ratio == null ? 0 : it.ratio
	}
	return ratio
}
