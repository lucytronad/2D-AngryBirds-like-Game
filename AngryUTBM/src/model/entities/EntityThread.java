package model.entities;

import java.util.ArrayList;

import model.ListChangedEvent;
import model.ListListener;


public class EntityThread extends Thread implements ListListener{
	private ArrayList<Entity> entities;
	
	public EntityThread(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	public void run(){
		while(true) {
			for(Entity entity : entities) {
				entity.move();
			}
			
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void listChanged(ListChangedEvent event) {
		this.entities = event.getEntityList();
	}
}
