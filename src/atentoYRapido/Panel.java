package atentoYRapido;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel extends JPanel{
		
	private Image imagen;
		
	public void paintComponent(Graphics g) {
			
		imagen = new ImageIcon(getClass().getResource("/images/fondo1.jpg")).getImage();	
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
			
	       setOpaque(false);
	       super.paintComponent(g);
	}

	/*public void setImagen(int index) {
			imagen = new ImageIcon(getClass().getResource("/images/"+index+".jpg")).getImage();	
			repaint();
	}*/

}


