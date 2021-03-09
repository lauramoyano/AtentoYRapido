package atentoYRapido;

import java.util.Random;

public class Cuadro {

	private int color;
	private boolean encendido;

	/**
	 * Gets the cara visible. Determina el valor de la cara visible.
	 *
	 * @return the cara visible. Un valor entre (1 - 6)
	 */
	public Cuadro() {
		Random aleatorio = new Random();
		color = aleatorio.nextInt(10) + 1;
		encendido = false;
		
	}
	
	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}

	public boolean isEncendido() {
		return encendido;
	}
	
	public int getColor() {
		return color;
	}
	
	public void setColor(int color) {
		this.color = color;
	}

	public void encerderCuadrado() {
		if(encendido) {
			encendido= false;
		}else {
			encendido= true;
		}
	}
	

	public void cambiarColor() {
		
		Random aleatorio = new Random();
		color = aleatorio.nextInt(10) + 1;
		
		int nuevoColor = aleatorio.nextInt(10) + 1;
		
		
		while( nuevoColor == color) {
			
			 aleatorio = new Random();
			 nuevoColor = aleatorio.nextInt(10) + 1;
			
		}
		color = nuevoColor;
		
	}
	

	
}
