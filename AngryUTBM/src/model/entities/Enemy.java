package model.entities;

abstract class Enemy extends Entity {
	
	protected boolean back;
	protected boolean down;
	protected int timeDirection;
	protected int timeDown;
	
	//un ennemi est cree avec sa position et sa taille
	public Enemy(int x, int y, int width, int height) {
		super(x,y,width, height);
	}
}