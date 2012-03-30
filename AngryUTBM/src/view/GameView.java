package view;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.Level;
import model.ListChangedEvent;
import model.ListListener;
import model.entities.Bird;
import model.entities.Egg;
import model.entities.Entity;

@SuppressWarnings("serial")
public class GameView extends JPanel implements ListListener {
	private Level map;
	private ArrayList<Entity> entities;
	private int frameHeight = 600;
	private int frameWidth = 1200;
	private Bird currentBird;
	private int currentHighestScore;
	private String slingShotName1 = "res/images/lance-pierre1.png";
	private Image slingShotImg1;
	private String slingShotName2 = "res/images/lance-pierre2.png";
	private Image slingShotImg2;
	
	public GameView(ArrayList<Entity> entities) {

        setFocusable(true);
        setDoubleBuffered(true);
        
        ImageIcon img1 = new ImageIcon(slingShotName1);
	    slingShotImg1 = img1.getImage(); 
	    ImageIcon img2 = new ImageIcon(slingShotName2);
	    slingShotImg2 = img2.getImage(); 
        
        this.entities = entities; 
	}
	
	public void paint(Graphics g) {
        super.paint(g);

        // On affiche le level
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(map.getImage(), 0, 0,frameWidth,frameHeight, this);
        g2d.drawImage(slingShotImg2, 100,440, this);
       
	    
	    int k = 0;
	    for(int i = entities.size()-1; i >=0;i--) {
	    	Entity e = entities.get(i);
		    	if(e instanceof Bird && e != currentBird) {
		    		g2d.drawImage(e.getImage(), frameWidth-100-k*15, 100,e.getImageWidth(),e.getImageHeight(), this);
		    		k++;
		    	}
	    		if(e == currentBird)
	    		{
	    			Egg egg = new Egg(0,0,28,30);
	    			for (int j = 0; j < currentBird.getEggLeft(); ++j) {
	        			g2d.drawImage(egg.getImage(), frameWidth-100+j*15, 20, this);
		    		}
	    	}
	    }
        
        for (Entity e : entities) {
        	if (!(e instanceof Bird)) { // on affiche pas tous les oiseaux, juste le courant
        		g2d.drawImage(e.getImage(), (int) e.getPosition().getX(), (int) e.getPosition().getY(), this);
        	}
        		if(e== currentBird )
        	{
        		g2d.setStroke(new BasicStroke(7.0f));
        		g2d.setColor(new Color(54, 28, 13));
        		if(!currentBird.isFlying())g2d.drawLine(135,470, (int)e.getPosition().getX()+e.getImageWidth()/2, (int)e.getPosition().getY()+e.getImageHeight()/2);
        		g2d.drawImage(e.getImage(), (int) e.getPosition().getX(), (int) e.getPosition().getY(),e.getImageWidth(),e.getImageHeight(), this);
        		if(!currentBird.isFlying())g2d.drawLine(120,470, (int)e.getPosition().getX()+e.getImageWidth()/2, (int)e.getPosition().getY()+e.getImageHeight()/2);
        		
        	}
        		g2d.setStroke(new BasicStroke(7.0f));
        		g2d.setColor(new Color(54, 28, 13));
        		if(currentBird.isFlying())g2d.drawLine(135,470,120,470);
        		g2d.setStroke(new BasicStroke(1.0f));
        		g2d.setColor(new Color(0, 0, 0));
        }
        
        
        g2d.drawImage(slingShotImg1, 100, 440, this);
        g.drawString("Highest Score : " + currentHighestScore, 10, 15);
        g.drawString("Flying time left : " + currentBird.getFlyingTimeLeft(), 10, 30);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
	
	public void setEntityList(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	

	public Level getMap() {
		return map;
	}

	public void setMap(Level map) {
		this.map = map;
	}
	
	public void setCurrentHighestScore(int highestScore) {
		this.currentHighestScore = highestScore;
	}

	@Override
	public void listChanged(ListChangedEvent event) {
		entities = event.getEntityList();
		currentBird = event.getCurrentBird();
		repaint();
		
	}
}
