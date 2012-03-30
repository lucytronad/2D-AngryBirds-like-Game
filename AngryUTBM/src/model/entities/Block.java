package model.entities;

import javax.swing.ImageIcon;

public class Block extends Entity{
	
	//un bloc de pierre est cree avec sa position et sa taille
	public Block(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		imagePath = "res/images/block.png";
		ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    imageHeight = ii.getIconHeight();
	    imageWidth = ii.getIconWidth();
	}

	@Override
	public void move() {
		
	}
	
}
