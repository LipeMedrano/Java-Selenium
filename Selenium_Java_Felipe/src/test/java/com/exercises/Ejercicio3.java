package com.exercises;

public class Ejercicio3 {

	public static void main(String[] args) {
		// Arreglos: 

		// Ejercicio #3 - Crear un arreglo unidimensional (como objeto) de 4 posiciones:
		
//		1- First Name
//		2- Middle Name
//		3- Last Name
//		4- Edad
		
//		**Imprimir el arreglo concatenando sus valores
		String[] values = new String[4];
		values[0] = "First Name";
		values[1] = "Middle Name";
		values[2] = "Last Name";
		values[3] = "Edad";
		
		String ArrayPrint = "";
		for(int i=0; i<values.length ; i++){
			//System.out.println(values[0]+", "+values[1]+", "+values[2]+", "+values[3]);
			 ArrayPrint = ArrayPrint + values[i]+", ";
		}
		System.out.println(ArrayPrint);
		
	}

}
