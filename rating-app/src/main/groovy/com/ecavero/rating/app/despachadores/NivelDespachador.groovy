package com.ecavero.rating.app.despachadores

import com.ecavero.rating.app.beans.*
import groovy.xml.*
import javax.jnlp.*

static def obtenerNiveles() {
	def url = ServiceManager.lookup("javax.jnlp.BasicService").codeBase.toString()
	def data = new URL("$url/NivelController.groovy").text
	data = new XmlParser().parseText(data)
	data = data.collect {
		n ->
		[
			id: n.idNivel.text() as int,
			descripcion: n.descripcion.text() 
		] as Nivel
	}
	return data
}

