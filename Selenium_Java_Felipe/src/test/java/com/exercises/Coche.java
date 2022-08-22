package com.exercises;

public class Coche {
	
	// Caracteristicas de un objeto
	
	/*
	 * 1- Estado: se representa con instancias de variable
	 * 2- Comportamiento: se representa con metodos
	 * 3- Identidad: permite que los objetos interactuen entre si.
	 */
	
	private int llantas;
	private int asientos;
	private String motor;
	private boolean ac;
	private String marca;
	private String modelo;
	
	// Constructores
	
	/*
	 * 1- Tiene el mismo nombre de la clase
	 * 2- No se hereda
	 * 3- No puede devolver ningun valor
	 * 4- Puede haber mas de un constructor (Sobrecarga de constructores)
	 */
	
	public Coche(int llantas, int asientos, String motor, boolean ac, String marca, String modelo) {
		this.llantas = llantas;
		this.asientos = asientos;
		this.motor = motor;
		this.ac = ac;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public Coche() {
		
	}
	
	public Coche(int asientos, String modelo) {
		this.llantas = 4;
		this.asientos = asientos;
		this.motor = "Combustion Interna";
		this.ac = true;
		this.marca = "Nissan";
		this.modelo = modelo;
	}
	
	public void acelerar() {
		System.out.println("El coche esta acelerando");
	}
	
	

	public void frenar() {
		System.out.println("El coche esta frenando");
	}
	
	public void encendido() {
		System.out.println("El coche esta encendido");
	}

	
	
	/*
	 * Encapsulation
	 * 
	 * Se puede definir como un mecanismo para ocultar instancias de variables 
	 * de una clase
	 * 
	 * 1- Tener variables de instancia privadas en metodos publicos.
	 */
	
	public int getLlantas() {
		return llantas;
	}

	public void setLlantas(int llantas) {
		if(llantas>6) {
			this.llantas = -1;
		}else {
			this.llantas = llantas;
		}
		
	}

	public int getAsientos() {
		return asientos;
	}

	public void setAsientos(int asientos) {
		this.asientos = asientos;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public boolean isAc() {
		return ac;
	}

	public void setAc(boolean ac) {
		this.ac = ac;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	

}
