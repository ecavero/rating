package com.ecavero.rating.app.despachadores

import com.ecavero.rating.app.beans.*
import groovy.xml.*
import javax.jnlp.*

static def obtenerRatio(idGenero, niveles, idElemento, edadMin, edadMax) {
	def url = ServiceManager.lookup("javax.jnlp.BasicService").codeBase.toString()
	def params = [idGenero:idGenero, idElemento: idElemento, edadMin: edadMin, edadMax: edadMax]
	params = params.collect {
		key, value ->
		"$key=$value"
	}.join("&")
	niveles = niveles.collect {
		n ->
		"nivel=${n}"
	}.join("&")
	def data = new URL("$url/RatioController.groovy?${params}&${niveles}").text
	data = new XmlParser().parseText(data)
	data = data.text() as double
	return data
}
