/*
 * Programación interactiva
 * Autor: Laura Moayno - 202023906
 * miniProyecto 1: juego atento y rapido
 */
package atentoYRapido;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Cuadro.
 */
public class Cuadro {

	private int color;
	private boolean encendido;

	/**
	 * asigna un color
	 *
	 */
	public Cuadro() {
		Random aleatorio = new Random();
		color = aleatorio.nextInt(11) + 1;
		encendido = false;
		
	}
	
	/**
	 * Sets the encendido.
	 *
	 * @param encendido the new encendido
	 */
	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}

	/**
	 * Checks if is encendido.
	 *
	 * @return true, if is encendido
	 */
	public boolean isEncendido() {
		return encendido;
	}
	
	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public int getColor() {
		return color;
	}
	
	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(int color) {
		this.color = color;
	}
	

	/**
	 * Cambiar color.
	 */
	public void cambiarColor() {
		
		Random aleatorio = new Random();
		color = aleatorio.nextInt(11) + 1;
		
		int nuevoColor = aleatorio.nextInt(11) + 1;
			
		color = nuevoColor;
		
	}
	

	
}
