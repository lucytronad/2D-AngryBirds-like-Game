package model.entities;
import java.awt.Dimension;
import java.util.ArrayList;

public abstract class Bird extends Entity {
	protected short flyingTime;
	protected int eggLeft;
	protected ArrayList<Egg> eggs;
	protected boolean isFlying;
	protected boolean isMoving;
	private double time;
	protected Dimension frameSize;
	private double accelX;
	private double accelY;
	protected int startLocationX;
	protected int startLocationY;
	private long lastTime;
	private long flyingTimeLeft;
	
	//l'oiseau est construit avec sa taille
	public Bird(int width, int height) {
		super(100,440,width,height);
		isMoving = false;
		time = 0.1;
		accelX = 0;
		startLocationX = 100;
		startLocationY = 440;
		accelY = 9.81;
		flyingTimeLeft = 10000;
	}
	
	public int getEggLeft() {
		return eggLeft;
	}
	
	public void setEggLeft(int i) {
		this.eggLeft = i;
	}
	public int getStartLocationX()
	{
		return startLocationX;
	}
	public int getStartLocationY()
	{
		return startLocationY;
	}
	
	public abstract void hovering(); //methode redefinie seulement pour les oiseaux capables de vol stationnaire
	
	public boolean isFlying() {
		return isFlying;
	}

    public void move() {
    	if(isFlying)
    	{
	    	if(isMoving)
	    	{
		    	hitBox.x = (int) Math.round(speed*Math.cos(angle)*time+0.5*accelX*time*time+startLocationX);
		    	hitBox.y = (int) Math.round(0.5*accelY*time*time-Math.sin(angle)*speed*time+startLocationY);
		    	time+=0.1;
	    	}
	    	long currentTime = System.currentTimeMillis();
	    	flyingTimeLeft -= (currentTime - lastTime);
	    	lastTime = currentTime;
    	}
	    	if (hitBox.y > (int) frameSize.getHeight() || hitBox.x > (int) frameSize.getWidth() ||flyingTimeLeft <= 0 )
	    		visible = false;
    }
    
    public void launch(){
    	isMoving = true;
    	isFlying = true;
    	lastTime = System.currentTimeMillis();
    }
    
	public void moveRight() {
		accelX+=0.1;
    }
    
    public void moveLeft() {
    	accelX-=0.1;
    }
	
	public long getFlyingTimeLeft() {
		return flyingTimeLeft;
	}
}
