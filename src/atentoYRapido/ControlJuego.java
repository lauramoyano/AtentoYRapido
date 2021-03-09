package atentoYRapido;

import java.util.ArrayList;
import java.util.Iterator;



public class ControlJuego {

	//private Cuadro c;
	private ArrayList <Cuadro> cuadros;
	private boolean boton;
	//private int estadoJuego;
	
	private int indexEncendido;
	private int nivelJuego;
	private int aciertos;
	private int vidas;
	
	//metodos
	public ControlJuego() {
		
		
		indexEncendido=0;
		nivelJuego =3;
		boton = false; // tiro inicial
		vidas = 3;
		aciertos = 0;
		cuadros = new ArrayList<Cuadro>();
		crearArray();
		
	}
	
	// cuantas veces está el color
	public int cuentaIguales(int color) { 
		int contador = 0;
		
		for(int i = 0; i < cuadros.size(); i++) {
			
			if(cuadros.get(i).getColor() == color) {
				 contador++;
			}
		}
		return contador;	
	}
	
	
	// si el color se puede agregar  o no
	
	public boolean maxCuadro(int color) {
		if(cuentaIguales(color) < 2) {
			return true;
		}
		return false;
	}
	
	
	//agrega un cuadro al array
	public void agregaCuadro(Cuadro cuadro) {
		int newColor = cuadro.getColor();
		if(maxCuadro(newColor)) {
			cuadros.add(cuadro);
		}else {
			cuadro.cambiarColor();
			cuadros.add(cuadro);	
		}
	}
	
	
	//cambia el color de los cuadros
	public void cambiarColor() {
		cuadros.get(indexEncendido).setEncendido(false);
		
		while(cuadros.get(indexEncendido).isEncendido()== false) {
			indexEncendido++;
			
			if(indexEncendido==8) {
				indexEncendido=0;
			}
			cuadros.get(indexEncendido).setEncendido(true);
			
			break;
			
		}
		cuadros.get(indexEncendido).cambiarColor();
	}
	
	
	// sumar punto o quitar vida
    public void iniciar() {
    	
    	int colorEncendido = cuadros.get(indexEncendido).getColor();
		//si hay dos cuadrados iguales  y boton = true + punto
    	if(cuentaIguales(colorEncendido) == 2 && boton) {	
    		aciertos++;
    		nivelJuego++;
    		crearArray();
    			
    			
    	}else if(cuentaIguales(colorEncendido) == 2 && !boton || cuentaIguales(colorEncendido) != 2 && boton ) {
    		vidas--;
    		nivelJuego--;
    		crearArray();
  
    			
   		}
		
	}
    
	public void setBoton(boolean boton) {
		this.boton = boton;
	}

	//genera un array list de cuadros nuevo
	public void crearArray() {
		int newColor = 1;
		cuadros.clear();
		
		if(nivelJuego < 3) {
			nivelJuego = 3;
		}
		for(int i = nivelJuego; i> 0; i--) {
			Cuadro newCuadro = new Cuadro();
			
			if(cuadros.size() == 8) {
				nivelJuego= 8;
				
				break;
			}
			while(cuentaIguales(newCuadro.getColor())>0) {
				newCuadro.setColor(newColor);
				newColor++;
			}
			cuadros.add(newCuadro);
			
		}
		
		
	}

	
	public void prueba() {
		
		Iterator <Cuadro> cuadross = cuadros.iterator();
		
		while(cuadross.hasNext()){
			Cuadro cuadro1 = cuadross.next();
			
			 System.out.print( cuadro1.getColor()+ "\n") ;
		}	
		
	}
	
	public int getNivelJuego() {
		return nivelJuego;
	}

	public int getVidas() {
		return vidas;
	}

	public int determinarAciertos() {
		
		return aciertos;
	}

	
	public int getAciertosTotales() {
		
		aciertos = determinarAciertos() * 5;
		return aciertos;
	}
}
