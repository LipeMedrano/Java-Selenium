package com.java.polimorfismo;

public class Main {

	public static void main(String[] args) {
		Animal ricardo = new Humano();
//		ricardo.speak();
		
		ricardo = new Perro();
		ricardo.speak();

	}

}
