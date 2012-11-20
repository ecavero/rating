package com.ecavero.rating.app.despachadores

import com.ecavero.rating.app.beans.*
import groovy.xml.*
import javax.jnlp.*

static def obtenerElementos() {
	def url = ServiceManager.lookup("javax.jnlp.BasicService").codeBase.toString()
	def data = new URL("$url/ElementoController.groovy").text
	data = new XmlParser().parseText(data)
	data = data.collect {
		e ->
		[
			id: e.idElemento.text() as int,
			descripcion: e.descripcion.text() 
		] as Elemento
	}
	return data
}
