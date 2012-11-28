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
							panel(border: BorderFactory.createTitledBorder(borde, "Edad")) {
								tableLayout {
									tr {
										td {
											label(text: "De")
										}
										td {
											panel size: [5,0]
										}
										td {
											textField(
												id: "edadMin",
												columns: 5
											)
										}
										td {
											panel size: [5,0]
										}										
										td {
											label(text: "a")
										}
										td {
											panel size: [5,0]
										}
										td {
											textField(
												id: "edadMax",
												columns: 5
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
											comboBox(
											id: "nivel",
											items: niveles
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
	def idNivel = sw.nivel.selectedItem.nivel.id as int
	def idElemento = sw.elemento.selectedItem.elemento.id as int
	def edadMin = sw.edadMin.text as int
	def edadMax = sw.edadMax.text as int
	def cantidad = sw.cantidad.text as int
	def ratio = RatingDespachador.obtenerRatio(idGenero, idNivel, idElemento, edadMin, edadMax)
	ratio *= cantidad
	sw.optionPane().showMessageDialog(sw.frmPrincipal, ratio)
}


