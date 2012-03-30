package model;
import java.util.ArrayList;
import java.util.EventObject;

import model.entities.Bird;
import model.entities.Entity;


@SuppressWarnings("serial")
public class ListChangedEvent extends EventObject {
	private ArrayList<Entity> entities;
	private Bird currentBird;
	
	public ListChangedEvent(Object source, ArrayList<Entity> entities, Bird b) {
		super(source);
		
		this.entities = entities;
		currentBird = b;
	}
	
	public ArrayList<Entity> getEntityList() {
		return entities;
	}
	
	public Bird getCurrentBird() {
		return currentBird;
	}
}
