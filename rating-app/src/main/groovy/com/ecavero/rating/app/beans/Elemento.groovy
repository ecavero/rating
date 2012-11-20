package com.ecavero.rating.app.beans

public class Elemento {
	int id
	String descripcion
}

public class ElementoDecorador {
	Elemento elemento
	public String toString() {
		elemento.descripcion
	}
}
