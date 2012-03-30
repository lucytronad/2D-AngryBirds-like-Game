package controller;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Locale;
import javax.swing.JOptionPane;
import main.GameFrame;
import model.GameModel;
import model.ListChangedEvent;
import model.ListListener;
import model.entities.Bird;
import model.entities.Sparrow;

public class GameController implements KeyListener, ListListener, MouseListener,MouseMotionListener{
	
	private GameModel angryModel;
	private GameFrame angryFrame;
	
	private Bird currentBird;
	private boolean isBirdPicked = false;
	
	public GameController(GameFrame Frame){
		angryFrame = Frame;
		angryModel = Frame.getAngryModel();
		JOptionPane.setDefaultLocale(Locale.ENGLISH);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {	
		switch (e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				if(currentBird.isFlying())
					currentBird.moveRight();
				break;
			case KeyEvent.VK_LEFT:
				if(currentBird.isFlying())
					currentBird.moveLeft();
				break;
			case KeyEvent.VK_UP:
				if(!currentBird.isFlying())
					currentBird.setAngle(currentBird.getAngle()+0.1);
				break;
			case KeyEvent.VK_DOWN:
				if(!currentBird.isFlying())
					currentBird.setAngle(currentBird.getAngle()-0.1);
				break;
			case KeyEvent.VK_S:
				// On interdit le vol stationaire pour les moineaux
				if(!(currentBird instanceof Sparrow))
					currentBird.hovering();
				break;
			case KeyEvent.VK_SPACE:
				if(currentBird.isFlying())
					angryModel.addEgg();
				break;
			case KeyEvent.VK_ESCAPE:
				angryFrame.setMenuLevel();
				break;
			default:
				System.out.println("je gere pas cette touche !");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void listChanged(ListChangedEvent event) {
		this.currentBird = event.getCurrentBird();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!currentBird.isFlying())
		{
			if(e.getX()>= currentBird.getPosition().getX() && e.getX() <= currentBird.getPosition().getX()+currentBird.getImageWidth())
				if(e.getY()>= currentBird.getPosition().getY() && e.getY() <= currentBird.getPosition().getY()+currentBird.getImageHeight())
				{
					isBirdPicked = true;
				}
			angryFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(isBirdPicked){
			int x = e.getX(),y = e.getY();
			if(y > 545-currentBird.getImageHeight()/2)
				y=545-currentBird.getImageHeight()/2;
			if(y < 400)
				y = 400;
			if(x < currentBird.getImageWidth()/2)
				x = currentBird.getImageWidth()/2;
			if(x > 200)
				x = 200;
			double deltaX = currentBird.getStartLocationX() - x;
			double deltaY = currentBird.getStartLocationY() - y;
			float speed = (float)Math.sqrt((deltaX*deltaX)+(deltaY*deltaY));
			currentBird.setAngle(-Math.atan(deltaY/deltaX));
			currentBird.setSpeed(speed);
			
			if(deltaX > 0)
				currentBird.launch();
			else{
				currentBird.setPosition(currentBird.getStartLocationX(), currentBird.getStartLocationY());
			}
		}
		angryFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		isBirdPicked = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(isBirdPicked)
		{
			int x = e.getX(),y = e.getY();
			if(y > 545-currentBird.getImageHeight()/2)
				y=545-currentBird.getImageHeight()/2;
			if(y < 400)
				y = 400;
			if(x < currentBird.getImageWidth()/2)
				x = currentBird.getImageWidth()/2;
			if(x > 200)
				x = 200;
			double deltaX = currentBird.getStartLocationX() - x;
			double deltaY = currentBird.getStartLocationY() - y;
			float speed = (float)Math.sqrt((deltaX*deltaX)+(deltaY*deltaY));
			currentBird.setAngle(-Math.atan(deltaY/deltaX));
			currentBird.setSpeed(speed);
			
			currentBird.setPosition(x-currentBird.getImageWidth()/2, y-currentBird.getImageHeight()/2);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}


