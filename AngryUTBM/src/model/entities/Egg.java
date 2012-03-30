package model.entities;

import javax.swing.ImageIcon;


public class Egg extends Entity {

	//un oeuf est cree avec sa position et sa taille
	public Egg(int x, int y, int width, int height) {
		super(x,y,width,height);
		imagePath = "res/images/egg.png";
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    imageHeight = ii.getIconHeight();
	    imageWidth = ii.getIconWidth();
		speed = 3; //vitesse de descente de l'oeuf
	}

	//l'oeuf ne se deplace que sur l'axe vertical (y)
	public void move() {
		hitBox.y += speed;
		speed+=0.1f;
	}
}

