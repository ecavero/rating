package com.ecavero.rating.app

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
											textField(columns: 5)
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
											textField(columns: 5)
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
											comboBox(items: ["Hombres", "Mujeres", "Hombres y Mujeres"] as String[])
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
											comboBox(items: ["A/B", "C", "D", "E"] as String[])
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
											label(text: "Elemento")
										}
										td {
											panel size: [5,0]
										}
										td {
											comboBox(items: ["Muros", "Relojes", "Paraderos", "Paletas"] as String[])
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
											textField(columns: 5)
										}										
									}
								}
							}							
						}
					}										
				}
			}
			panel(constraints: BorderLayout.SOUTH) {
				button(text: "Calcular")
				button(text: "Cerrar", actionPerformed: {
					cerrar(sw)
				})
			}
		}
}
sw.frmPrincipal.pack()
sw.frmPrincipal.visible = true

static def cerrar(sw) {
	sw.frmPrincipal.dispose()
}
