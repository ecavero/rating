package com.ecavero.rating.app.beans

public class Edad {
	int edadMin
	int edadMax
	
	public String toString() {
		if (edadMax != 999)
			return "$edadMin a $edadMax años"
		else
			return "$edadMin a más años"
	}
}
