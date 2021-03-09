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
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import misComponentes.Titulos;

public class VistaGUI extends JFrame {
	
	private JPanel zonaJuego,  zonaResultado;

	private Panel prueba;
	private ArrayList <JLabel> cuadros;
	
	private JLabel puntaje;
	private JLabel aciertos;
	private JLabel fallas;
	//private Border borde;

	private Titulos titulo;
	//private Titulos resultados;
	private JTextField vidas;
	private JTextField puntos;
	
	private JButton jugar;
	private JButton salir;
	private JButton lanzar;
	
	private ControlJuego control;
	private Escucha escucha;
	private Random random;
	private Timer time;
	
	private ImageIcon imagen;
	
	//Metodos
	
	//constructor
	public VistaGUI() {
		initGUI();
		
		
		//set default window configuration
		this.setTitle("Atento y Rapido");
		this.setUndecorated(true);
		//this.setBackground(new Color(80, 0, 10, 220 ));
		this.pack();
		//this.setSize(900, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void initGUI() {
		
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		//create listen objects, control and others
		escucha = new Escucha();
		control = new ControlJuego();
		random = new Random();
		time = new Timer(3000,escucha);

		//set up  GUI components 
		titulo = new Titulos("Atento & Rapido", 30, new Color(0, 0, 0));
		//titulo.addMouseListener(escucha);
		//titulo.addMouseMotionListener(escucha);
		titulo.setCursor(new Cursor(Cursor.MOVE_CURSOR));
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.gridwidth= 4;
		constraints.gridheight = 1;
		constraints.fill= GridBagConstraints.HORIZONTAL;
		
		add(titulo, constraints);
		
		//zonaResultados
		zonaResultado =new JPanel();
		zonaResultado.setBackground(new Color(60,0,10));
		zonaResultado.setLayout(new GridLayout(2,2));
		aciertos = new JLabel("Puntos");
		fallas = new JLabel("Vidas");
		Border border = BorderFactory.createLineBorder(new Color(255, 102, 0), 5);
		fallas.setBorder(border);
		aciertos.setBorder(border);
		vidas = new JTextField(2);
		vidas.setEditable(false);
		vidas.setBackground(new Color(255, 204, 153));
		puntos = new JTextField(2);
		puntos.setEditable(false);
		puntos.setBackground(new Color(255, 204, 153));
		
		zonaResultado.add(fallas);
		zonaResultado.add(vidas);
		zonaResultado.add(aciertos);
		zonaResultado.add(puntos);
		zonaResultado.setBackground(Color.LIGHT_GRAY);
		
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.gridwidth= 4;
		constraints.gridheight=1;
		constraints.fill= GridBagConstraints.NONE;
		//constraints.anchor =GridBagConstraints.CENTER;
		
		add(zonaResultado, constraints);
		

		
		//la zona de juego
		zonaJuego =new JPanel();
		
		zonaJuego.setPreferredSize(new Dimension (700, 300));
		zonaJuego.setBackground(new Color(204,255,255));
		
		cuadros = new ArrayList();
		
		for(int i=0; i <9; i++) {
			
				control.crearArray();
				cuadros.add(new JLabel());
				zonaJuego.add(cuadros.get(i));
				imagen = new ImageIcon("src/imagenes/" + i + ".jpg");
			 	cuadros.get(i).setIcon(imagen);
			
		}	
		
		constraints.gridx=0;
		constraints.gridy=2;
		constraints.gridwidth= 4;
		constraints.gridheight=3;
		constraints.fill= GridBagConstraints.NONE;
		
		add(zonaJuego, constraints);
		
		//zonaResultado configuration 
		zonaResultado =new JPanel();
		//zonaJuego.setLayout(new GridBagLayout());
		//GridBagConstraints constraints1 = new GridBagConstraints();
		zonaResultado.setPreferredSize(new Dimension (700, 65));
		zonaResultado.setBackground(Color.GRAY);
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.gridwidth= 4;
		constraints.gridheight=3;
		constraints.fill= GridBagConstraints.NONE;
		
		add(zonaResultado, constraints);
		
		//boton lanzar
		lanzar = new JButton("Tirar");
		lanzar.addActionListener(escucha);
		lanzar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lanzar.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		constraints.gridx=2;
		constraints.gridy=5;
		constraints.gridwidth= 2;
		constraints.gridheight=2;
		constraints.fill= GridBagConstraints.HORIZONTAL;
		constraints.anchor =GridBagConstraints.CENTER;

		add(lanzar, constraints);

		//boton salir
		salir = new JButton("Salir");
		salir.addActionListener(escucha);
		salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		constraints.gridx=3;
		constraints.gridy=7;
		constraints.gridwidth= 1;
		constraints.gridheight=1;
		constraints.fill= GridBagConstraints.NONE;
		constraints.anchor =GridBagConstraints.LAST_LINE_END;

		add(salir, constraints);
		
		

	}
	
	
	private class Escucha implements ActionListener{

		
		public void actionPerformed(ActionEvent event) {
			
			vidas.setText(String.valueOf(control.getVidas()));
			puntos.setText(String.valueOf(control.determinarAciertos()));
			
			if(event.getSource() == salir) {
				System.exit(0);
			}
			if(event.getSource()==time) {
				control.iniciar();
			}
			if(event.getSource()==lanzar) {
				control.setBoton(true);
				control.iniciar();
				control.setBoton(false);
				
			}
			
		}
		
	}

}
