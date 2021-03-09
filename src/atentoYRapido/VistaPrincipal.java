package atentoYRapido;

import java.awt.EventQueue;

public class VistaPrincipal {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ControlJuego  control = new ControlJuego();
		
		
		//control.agregaCuadros();
		//control.crearArray();
		//control.prueba();
		//control.agregaCuadros();
		
		/*
		 * System.out.println("#  "+control.cuentaIguales(1)+ "\n");
		 * System.out.println("#  "+control.cuentaIguales(5)+ "\n");
		 * System.out.println("#  "+control.cuentaIguales(3)+ "\n");
		 */
		EventQueue.invokeLater(new Runnable() {

		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				 new VistaGUI();
			}
			
		});
	}

}
