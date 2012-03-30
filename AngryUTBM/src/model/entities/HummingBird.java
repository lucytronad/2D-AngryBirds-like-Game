package model.entities;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public class HummingBird extends Bird {	
	public HummingBird() {
		super(45, 44);
	    imagePath = "res/images/hummingBird.png";
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    speed = 100;
	    imageHeight = ii.getIconHeight();
	    imageWidth = ii.getIconWidth();
	    eggs = new ArrayList<Egg>();
	    eggLeft = 1;
	    frameSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	}
    
    public void hovering() {
    	isMoving = !isMoving;
    }
    
    public ArrayList<Egg> getEggs() {
    	return eggs;
    }
    
    
}
