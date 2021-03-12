/*
 * Programación interactiva
 * Autor: Laura Moayno - 202023906
 * miniProyecto 1: juego atento y rapido
 */
package atentoYRapido;

import java.awt.EventQueue;

public class AtentoRapido {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
			
			  EventQueue.invokeLater(new Runnable() {
			  
			  
			  @Override public void run() { // TODO Auto-generated method stub new VistaGUI
			  VistaGUI view = new VistaGUI(); }
			  
			  });
			 
		 
	}

}
