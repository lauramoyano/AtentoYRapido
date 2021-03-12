/*
 * Programación interactiva
 * Autor: Laura Moayno - 202023906
 * miniProyecto 1: juego atento y rapido
 */

package atentoYRapido;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

// TODO: Auto-generated Javadoc
/**
 * clase que acomoda cada elemento en la interface y les genera los escuhas que permite el modelo vista- controlador.
 */
public class VistaGUI extends JFrame {

	
	private PanelResultado zonaResultado;
	private PanelJuego zonaJuego;

	private Titulos titulo;
	
	private JButton leave;
	private JButton start;
	private JButton restart;
	
	private ControlJuego control;
	private Escucha escucha;
	private Timer time;
	private JFrame refWindow;

	// Metodos

	/**
	 * Instantiates a new vista GUI.
	 */
	// constructor
	public VistaGUI() {
		initGUI();

		// set default window configuration
		this.setTitle("Atento y Rapido");
		this.setUndecorated(true);
		this.setBackground(new Color(255,255,255));
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * Inits the GUI.
	 */
	private void initGUI() {

		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		// create listen objects, control and others
		escucha = new Escucha();
		control = new ControlJuego();
		time = new Timer(2000, escucha);
		refWindow = this;

		// set up GUI components
		
		//Titulo
		titulo = new Titulos("Atento & Rápido", 35, new Color(255, 153, 0));
		titulo.addMouseListener(escucha);
		titulo.addMouseMotionListener(escucha);
		titulo.setCursor(new Cursor(Cursor.MOVE_CURSOR));
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 4;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;

		add(titulo, constraints);

		// zonaResultados
		zonaResultado = new PanelResultado();
		zonaResultado.setVidas(control);
		zonaResultado.setPuntos(control);

		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 4;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		// constraints.anchor =GridBagConstraints.CENTER;

		add(zonaResultado, constraints);

		// la zona de juego
		zonaJuego = new PanelJuego(); 
		zonaJuego.setImage(control);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 4;
		constraints.gridheight = 3;
		constraints.fill = GridBagConstraints.NONE;

		add(zonaJuego, constraints);

		// boton lanzar
		start = new JButton("Tirar");
		start.addActionListener(escucha);
		start.setCursor(new Cursor(Cursor.HAND_CURSOR));
		start.setBorder(BorderFactory.createLineBorder(new Color(255, 180, 0),6));
		constraints.gridx = 2;
		constraints.gridy = 5;
		constraints.gridwidth = 2;
		constraints.gridheight = 2;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.anchor = GridBagConstraints.CENTER;

		add(start, constraints);

		// boton salir
		leave = new JButton("Salir Juego");
		leave.addActionListener(escucha);
		leave.setCursor(new Cursor(Cursor.HAND_CURSOR));
		leave.setBorder(BorderFactory.createLineBorder(Color.GRAY,4));
		constraints.gridx = 3;
		constraints.gridy = 7;
		constraints.gridwidth = 1;
		constraints.gridheight = 2;
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.LAST_LINE_END;

		add(leave, constraints);
		
		// boton reiniciar
		restart = new JButton("Reiniciar Partida");
		restart.addActionListener(escucha);
		restart.setCursor(new Cursor(Cursor.HAND_CURSOR));
		restart.setBorder(BorderFactory.createLineBorder(new Color(255,102,0),4));
		constraints.gridx = 3;
		constraints.gridy = 7;
		constraints.gridwidth = 1;
		constraints.gridheight = 2;
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.LAST_LINE_START;

		add(restart, constraints);
		
		time.start();

	}

	/**
	 * The Class Escucha.
	 */
	private class Escucha implements ActionListener, MouseListener, MouseMotionListener {
		
		private int x;
		private int y;

		/**
		 * Action performed.
		 *
		 * @param event the event
		 */ 
		public void actionPerformed(ActionEvent event) {
			Icon icon;
			String aciertosTotales = "Puntos: " + String.valueOf(zonaResultado.setPuntuacion(control)) + "\n";
			String puntosTotales = "Aciertos: " + String.valueOf(zonaResultado.puntosTotales(control)) + "\n";

			if (event.getSource() == leave) {
				System.exit(0);
			}
			if (event.getSource() == time) {
				control.starts();
				zonaResultado.setVidas(control);
			}
			if (event.getSource() == start) {
				control.setBoton(true);  
				control.starts();
				zonaResultado.setVidas(control);
				zonaResultado.setPuntos(control);
				control.setBoton(false);
				time.restart();

			} 
			if(control.getLives()== 0) { //game over vidas=0
				icon= new ImageIcon("src/iconos/icon.png");
				JOptionPane.showInternalMessageDialog(null, "Fallas: 3 \n" + aciertosTotales + puntosTotales,
					"Resultado Final!" , JOptionPane.DEFAULT_OPTION, icon); 
				time.stop();
				
			}if (event.getSource() == restart) {//start new game
				refWindow.dispose();
				AtentoRapido.main(null);

			} 

			zonaJuego.setImage(control);

		}

		/**
		 * Mouse dragged.
		 *
		 * @param eventMouseMotion the event mouse motion
		 */
		@Override
		public void mouseDragged(MouseEvent eventMouseMotion) {
			// TODO Auto-generated method stub
			setLocation(refWindow.getLocation().x + eventMouseMotion.getX() - x,
					refWindow.getLocation().y + eventMouseMotion.getY() - y);
		}

		/**
		 * Mouse moved.
		 *
		 * @param e the e
		 */
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		/**
		 * Mouse clicked.
		 *
		 * @param e the e
		 */
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		/**
		 * Mouse pressed.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mousePressed(MouseEvent eventMouse) {
			// TODO Auto-generated method stub
			x = eventMouse.getX();
			y = eventMouse.getY();
		}

		/**
		 * Mouse released.
		 *
		 * @param e the e
		 */
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		/**
		 * Mouse entered.
		 *
		 * @param e the e
		 */
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		/**
		 * Mouse exited.
		 *
		 * @param e the e
		 */
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
