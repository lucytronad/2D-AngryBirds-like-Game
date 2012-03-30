package model.entities;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Pigeon extends Bird {
	
	
	public Pigeon() {
		super(50, 48);
	    imagePath = "res/images/pigeon.png";
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    speed = 100;
	    eggs = new ArrayList<Egg>();
	    eggLeft = 3;
	    frameSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	}
    
	/** La fonction hovering stoppe la course de l'oiseau **/
    public void hovering() {
    	isMoving = !isMoving;
    }
    
    
    public ArrayList<Egg> getEggs() {
    	return eggs;
    }
}
