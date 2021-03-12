/*
 * Programación interactiva
 * Autor: Laura Moayno - 202023906
 * miniProyecto 1: juego atento y rapido
 */
package atentoYRapido;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * The Class ControlJuego.
 */
public class ControlJuego {

	private ArrayList <Cuadro> cuadros;
	
	private boolean button;
	private int indexShining;
	private int levelGame;
	private int hits;
	private int lives;
	
	//metodos
	
	/**
	 * Instantiates a new control juego.
	 */
	public ControlJuego() {
		
		
		indexShining=0;
		button = false; 
		lives = 3;
		hits = 0;
		cuadros = new ArrayList<Cuadro>();
		modifyArray();
		
	}
	
	/**
	 * Gets the index encendido.
	 *
	 * @return the index encendido
	 */
	public int getIndexShining() {
		return indexShining;
	}

	/**
	 * Gets the cuadros.
	 *
	 * @return ArrayList the cuadros
	 */
	//obtenerArray
	public ArrayList<Cuadro> getCuadros() {
		return cuadros;
	}
	
	/**
	 * cuantas veces está el color en el ArrayList
	 *
	 * @param int color de busqueda
	 * @return int el numero de veces
	 */
	// cuantas veces está el color
	public int countColors(int color) { 
		int contador = 0;
		
		for(int i = 0; i < cuadros.size(); i++) {
			
			if(cuadros.get(i).getColor() == color) {
				 contador++;
			}
		}
		return contador;	
	}
	
	
	/**
	 * determina si el color se puede agregar  o no
	 *
	 * @param color the color
	 * @return true, if successful
	 */
	public boolean maxCuadro(int color) {
		if(countColors(color) < 2) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * obtiene el indice encendido y le cambia el color, en cada poscion del ArrayList
	 */
	//cambia el color de los cuadros
	public void changerColor() {
		cuadros.get(indexShining).setEncendido(false);
		
		while(cuadros.get(indexShining).isEncendido()==false) {
			indexShining++;
			
			if(indexShining== cuadros.size()) {
				indexShining=0;
			}
			if(cuadros.get(indexShining).getColor()!=0) {
			cuadros.get(indexShining).setEncendido(true);
			
			break;
			}
			
		}
		cuadros.get(indexShining).cambiarColor();
	}
	
	
	/**
	 * Inicia la partida, verificando si ha ganado 
	 * puntos o perdido vidas y genera un arrayList nuevo cada partida
	 */
	// sumar punto o quitar vida
    public void starts() {
    	
    	if(cuadros.get(indexShining).isEncendido()) {
    		int colorEncendido = cuadros.get(indexShining).getColor();
    		//si hay dos cuadrados iguales  y boton = true + punto
    		if(countColors(colorEncendido) == 2 && button) {	
    			hits++;
    			levelGame++;
    			modifyArray();

    		}else if(countColors(colorEncendido) == 2 || button==true ) {
    			lives-=1;
    			//nivelJuego--;
    			modifyArray();

    		}
    		//this.cambiarColor();
    	}
    	this.changerColor();
		
	}
    
	/**
	 * Sets the boton.
	 *
	 * @param boton the new boton
	 */
	public void setBoton(boolean boton) {
		this.button = boton;
	}

	/**
	 * crea un nuevo, con el minimo tamaño de tres y máximo de 8
	 *  sin que repita un color
	 */
	public void modifyArray() { 
		int newColor = 1;
		cuadros.clear();
	
		if(levelGame < 3) {
			levelGame = 3;
		}
		for(int i = levelGame; i > 0; i--) {
			Cuadro newCuadro = new Cuadro();
			
			if(cuadros.size() == 8) {
				levelGame= 8;
				
				break;
			}
			while(countColors(newCuadro.getColor())>0) {
				newCuadro.setColor(newColor);
				newColor++;
			}
			cuadros.add(newCuadro);			
		}
		
		
	}

	
	/**
	 * Prueba, para imprimir los colores de los cuadros en consola
	 */
	public void prueba() {
		
		Iterator <Cuadro> cuadross = cuadros.iterator();
		
		while(cuadross.hasNext()){
			Cuadro cuadro1 = cuadross.next();
			
			 System.out.print( cuadro1.getColor()+ "\n") ;
		}	
		
	}
	

	/**
	 * Gets the lives
	 *
	 * @return the vidas
	 */
	public int getLives() {
		return lives;
	}

	/**
	 * gets the hits
	 *
	 * @return the hits
	 */
	public int determinedHits() {
		return hits;
	}


	/**
	 * Gets the aciertos totales
	 *
	 * @return the aciertos totales
	 */
	public int getTotalHits() {
		int puntos = hits *5;
		return puntos;
	}
}
