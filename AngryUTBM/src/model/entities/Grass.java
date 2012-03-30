package model.entities;

import javax.swing.ImageIcon;

public class Grass extends Entity {

	//un bloc de pierre est cree avec sa position et sa taille
	public Grass(int x, int y, int width, int height) {
		super(x, y, width, height);

		imagePath = "res/images/grass.png";
		ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    imageHeight = ii.getIconHeight();
	    imageWidth = ii.getIconWidth();
	}

	@Override
	public void move() {
		
	}

}
