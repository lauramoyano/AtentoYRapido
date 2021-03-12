/*
 * Programación interactiva
 * Autor: Laura Moayno - 202023906
 * miniProyecto 1: juego atento y rapido
 */
package atentoYRapido;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelResultado.
 */
public class PanelResultado extends JPanel {
	

	private JLabel aciertos, fallas;
	private JTextField vidas, puntos;
	
	private int puntosFinal, puntosTotales;
	
	//zonaResultados

	/**
	 * Instantiates a new panel resultado.
	 */
	public PanelResultado() {
		
		this.setBackground(new Color(60,0,10)); 
		this.setLayout(new GridLayout(2,2));
		this.setPreferredSize(new Dimension (200, 65));
		
		aciertos = new JLabel("Aciertos");
		fallas = new JLabel("Vidas");
		Border border = BorderFactory.createLineBorder(new Color(0, 0, 0), 4);
		fallas.setBorder(border);
		aciertos.setBorder(border);
		vidas = new JTextField(2);
		vidas.setEditable(false);
		vidas.setBackground(new Color(255,255,255));
		puntos = new JTextField(2);
		puntos.setEditable(false);
		puntos.setBackground(new Color(255, 255, 255));
		
//		vidas.setText(String.valueOf(control.getVidas()));
//		puntos.setText(String.valueOf(control.determinarAciertos()));
		
		add(fallas);
		add(vidas);
		add(aciertos);
		add(puntos);
		setBackground(Color.LIGHT_GRAY);
		
	
		
	}
	

	/**
	 * Sets the puntos.
	 *
	 * @param control the new puntos
	 */
	public void setPuntos(ControlJuego control) {
		puntos.setText(String.valueOf(control.determinedHits()));
	}

	/**
	 * Sets the vidas.
	 *
	 * @param control the new vidas
	 */
	public void setVidas(ControlJuego control) {
		vidas.setText(String.valueOf(control.getLives()));
	}
	
	/**
	 * retorna Puntos en partida
	 *
	 * @param control the control
	 * @return the int
	 */
	public int puntosTotales(ControlJuego control) {
		return puntosTotales = control.determinedHits() ;

	}

	/**
	 * determina la puntuación final.
	 *
	 * @param control the control
	 * @return the int
	 */
	public int setPuntuacion(ControlJuego control) {
		return puntosFinal = control.getTotalHits();

	}

}
