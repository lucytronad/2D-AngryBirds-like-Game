package model.entities;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class Entity {
	protected float speed;
	protected String imagePath;
	protected Image image;
	protected int imageWidth;
	protected int imageHeight;
	protected boolean visible = true;
	protected Rectangle hitBox;
	protected double angle;

	//une entite est cree avec sa position et sa taille
	public Entity(int x, int y, int width, int height) {
		hitBox = new Rectangle(x, y, width, height);
		imageWidth=width;
		imageHeight=height;
	}
	
	public Point getPosition() {
		return new Point(hitBox.x, hitBox.y);
	}
	
	public Image getImage() {
        return this.image;
    }
	
	//la methode est redefinie dans les entites qui se deplacent
	abstract public void move();
	
	public boolean isVisible() {
		return this.visible;
	}
	
	public Rectangle getHitBox() {
		return hitBox;
	}
	
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public void setAngle(double a){angle=a;}
	public double getAngle(){return angle;}
	public double getSpeed(){return speed;}
	public int getImageWidth(){return imageWidth;}
	public int getImageHeight(){return imageHeight;}
	
	public void setPosition(int x, int y) {
		hitBox.x = x;
		hitBox.y = y;
	}
}
