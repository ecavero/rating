package com.ecavero.rating.app.despachadores

import com.ecavero.rating.app.beans.*
import groovy.xml.*
import javax.jnlp.*

static def obtenerGeneros() {
	def url = ServiceManager.lookup("javax.jnlp.BasicService").codeBase.toString()
	def data = new URL("$url/GeneroController.groovy").text
	data = new XmlParser().parseText(data)
	data = data.collect {
		d ->
		[
			id: d.idGenero.text() as int,
			descripcion: d.descripcion.text()
		] as Genero
	}
	return data
}

