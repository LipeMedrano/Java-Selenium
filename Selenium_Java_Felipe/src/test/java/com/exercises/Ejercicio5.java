package com.exercises;

import com.access1.AccessModifier1;

public class Ejercicio5 extends AccessModifier1{

	public static void main(String[] args) {
		
		// Ejercicio# 5
		
		/*
		 * Crear una clase que se llame Motos y vamos a crear 3 diferentes tipos de motos con estados y comportamientos.
		 */
		
		Motos moto1 = new Motos(1,"2002");
		System.out.println("Mi moto1 tiene "+moto1.getAsientos()+" asientos");
		System.out.println("Mi moto1 tiene "+moto1.getLlantas()+" llantas");
		System.out.println("Mi moto1 es modelo: "+moto1.getMarca());
		System.out.println("\n");
		moto1.encendido();
		
		Motos moto2 = new Motos(2,"2000");
		moto2.setLlantas(4);
		System.out.println("Mi moto2 tiene "+moto2.getAsientos()+" asientos");
		System.out.println("Mi moto2 tiene "+moto2.getLlantas()+" llantas");
		moto2.caballito();
		System.out.println("\n");
		
		Motos moto3 = new Motos(6,"2002");
		moto3.setLlantas(6);
		System.out.println("Mi moto3 tiene "+moto3.getAsientos()+" asientos");
		System.out.println("Mi moto3 tiene "+moto3.getLlantas()+" llantas");
		System.out.println("Mi moto3 es modelo: "+moto3.getModelo());
		moto3.encendido();
		moto3.acelerar();
		
		
		

	}

}
