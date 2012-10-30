package com.ecavero.rating.app

import groovy.swing.*
import javax.swing.*

sw = new SwingBuilder()
sw.edt {
	frame(
		id: "frmPrincipal",
		defaultCloseOperation: JFrame.EXIT_ON_CLOSE
		
		) {
			panel {
				label(text: "hola")
			}
		}
}
sw.frmPrincipal.pack()
sw.frmPrincipal.visible = true
