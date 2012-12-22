package com.ecavero.rating.app.despachadores

import com.ecavero.rating.app.beans.*
import groovy.xml.*
import javax.jnlp.*

static def obtenerEdades() {
	def url = ServiceManager.lookup("javax.jnlp.BasicService").codeBase.toString()
	def data = new URL("$url/EdadController.groovy").text
	data = new XmlParser().parseText(data)
	data = data.collect {
		d ->
		[
			edadMin: d.edadMin.text() as int,
			edadMax: d.edadMax.text() as int
		] as Edad
	}
	return data
}
