package com.java;

import com.access1.AccessModifier1;
import com.access2.AccessModifier2;

public class Ejercicio5 extends AccessModifier1{

	public static void main(String[] args) {
		
//		Coche coche1 = new Coche();
//		coche1.llantas = 4;
//		coche1.asientos = 5;
//		coche1.ac = true;
//		coche1.marca = "BMW";
//		coche1.modelo = "2020";
//		coche1.motor = "Hibrido";
//		
//		System.out.println("El modelo del coche 1 es: "+ coche1.modelo);
//		
//		coche1.encendido();
//		coche1.acelerar();
//		
//		Coche coche2 = new Coche(2, 2, "Electrico", false, "Audi", "2021");
//		System.out.println("El modelo del coche 2 es: "+ coche2.modelo);
		
		Coche coche3 = new Coche(5, "2022");
		//System.out.println("Mi coche 3 tiene "+ coche3.getLlantas() + " Llantas");
		coche3.setLlantas(1000);
		//System.out.println("Mi coche 3 tiene "+ coche3.getLlantas() + " Llantas");
		
		
		// Ejercicio# 5
		
		/*
		 * Crear una clase que se llame Motos y vamos a crear 3 diferentes tipos de motos con estados y comportamientos.
		 */
		
		//Motocicleta moto1 = new Motocicleta();
		//moto1.acelerar();
//		moto1.llantas = 2;
		
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
