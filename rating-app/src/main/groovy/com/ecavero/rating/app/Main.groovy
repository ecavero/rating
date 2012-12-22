package com.ecavero.rating.app

import com.ecavero.rating.app.beans.*
import com.ecavero.rating.app.despachadores.*
import groovy.swing.*
import java.awt.*
import javax.swing.*
import javax.swing.border.*


sw = new SwingBuilder()
sw.lookAndFeel("system")
sw.edt {
	def borde = BorderFactory.createEtchedBorder EtchedBorder.LOWERED
	frame(
		id: "frmPrincipal",
		title: "Sistema",
		defaultCloseOperation: JFrame.EXIT_ON_CLOSE
		
		) {
			panel(constraints: BorderLayout.CENTER) {
				tableLayout {
					tr {
						td {
							panel {
								tableLayout {
									tr {
										td {
											label(text: "Edad")
										}
										td {
											panel size: [5,0]
										}
										td {
											def edades = EdadDespachador.obtenerEdades()
											comboBox(
												id: "edad",
												items: edades
											)
										}
									}
								}
							}
						}
					}
					tr {
						td {
							panel {
								tableLayout {
									tr {
										td {
											label(text: "Género")
										}
										td {
											panel size: [5,0]
										}
										td {
											def generos = GeneroDespachador.obtenerGeneros()
											generos = generos.collect {
												g ->
												new GeneroDecorador(genero: g)
											}
											comboBox(
												id: "genero",
												items: generos
											)
										}										
									}
								}
							}
						}
					}
					tr {
						td {
							panel {
								tableLayout {
									tr {
										td {
											label(text: "Nivel SE")
										}
										td {
											panel size: [5,0]
										}
										td {
											def niveles = NivelDespachador.obtenerNiveles()
											niveles = niveles.collect {
												n ->
												new NivelDecorador(nivel: n)
											}
											scrollPane(
												preferredSize: [150,150]
											) {
												list(
													id: "nivel",
													items: niveles
												)
											}
										}										
									}
								}
							}							
						}
					}
					tr {
						td {
							panel {
								tableLayout {
									tr {
										td {
											label(
												text: "Elemento"
											)
										}
										td {
											panel size: [5,0]
										}
										td {
											def elementos = ElementoDespachador.obtenerElementos()
											elementos = elementos.collect {
												e ->
												new ElementoDecorador(elemento: e)
											}
											comboBox(
											id: "elemento",
											items: elementos
											)
										}
									}
								}
							}							
						}
					}
					tr {
						td {
							panel {
								tableLayout {
									tr {
										td {
											label(text: "Cantidad")
										}
										td {
											panel size: [5,0]
										}
										td {
											textField(
												id: "cantidad",
												columns: 5
											)
										}										
									}
								}
							}							
						}
					}										
				}
			}
			panel(constraints: BorderLayout.SOUTH) {
				button(text: "Calcular", actionPerformed: {
					calcular(sw)
				})
				button(text: "Cerrar", actionPerformed: {
					cerrar(sw)
				})
			}
		}
}
sw.frmPrincipal.pack()
sw.frmPrincipal.visible = true

static def cerrar(sw) {
	System.exit(0)
}

static def calcular(sw) {
	def idGenero = sw.genero.selectedItem.genero.id as int
	def niveles = sw.nivel.selectedValues
	if (!niveles) {
		sw.optionPane().showMessageDialog(sw.frmPrincipal, "Debe elegir al menos un nivel SE", null, JOptionPane.ERROR_MESSAGE)
		return
	}
	niveles = niveles.collect {
		n ->
		n.nivel.id
	}
	def idElemento = sw.elemento.selectedItem.elemento.id as int
	def edadMin = sw.edad.selectedItem.edadMin
	def edadMax = sw.edad.selectedItem.edadMax
	if (sw.cantidad.text.empty) sw.cantidad.text = "0"
	def cantidad = sw.cantidad.text as int
	def ratio = RatingDespachador.obtenerRatio(idGenero, niveles, idElemento, edadMin, edadMax)
	ratio *= cantidad
	sw.optionPane().showMessageDialog(sw.frmPrincipal, ratio)
}


