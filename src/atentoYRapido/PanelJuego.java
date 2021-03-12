/*
 * Programación interactiva
 * Autor: Laura Moayno - 202023906
 * miniProyecto 1: juego atento y rapido
 */
package atentoYRapido;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * Clase que hereda de JPanel y contiene los cuadrados en juego y les asigna una imagen 
 */
public class PanelJuego extends JPanel{
	

	private ArrayList<JLabel> cuadros;
	
	private ImageIcon imagen;
	private ImageIcon invisible;



	/**
	 * Instantiates a new panel juego.
	 */
	public PanelJuego() {
	
		this.setPreferredSize(new Dimension (650, 300));
		//this.setLayout(new GridLayout(4, 2, 10, 10));
		this.setBackground(new Color(0,0,0));
		cuadros = new ArrayList();
		//setImage();
	
	}
	
	/**
	 * Sets the image for arrayList<JLabel> 
	 *
	 * @param instancia de la clase ControlJuego
	 */
	public void setImage(ControlJuego control) {
		//cuadros.clear();
		for(int i=0; i < control.getCuadros().size(); i++) {
			
//			control.crearArray();
			cuadros.add(new JLabel());
			this.add(cuadros.get(i));
			
			imagen = new ImageIcon("src/imagenes/" + String.valueOf(control.getCuadros().get(i).getColor())+ ".jpg");
			cuadros.get(i).setIcon(imagen);
			
			if(control.getCuadros().get(i).isEncendido()) {
				cuadros.get(i).setBorder(BorderFactory.createLineBorder(new Color(0, 204, 205), 4));
				
			}else {
				cuadros.get(i).setBorder(null);
			}
			 /*if(control.getCuadros().size() < cuadros.size()) { 
				 invisible = new ImageIcon("src/imagenInvisible/0.png");
				 
				 JLabel ultimoCuadro = cuadros.get(cuadros.size()-1);
				 ultimoCuadro.setIcon(invisible);
				 
			 }*/
			 
			
		}	
		
	}

}
