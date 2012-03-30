package model;
import java.util.EventListener;


public interface ListListener extends EventListener {
	public void listChanged(ListChangedEvent event);
}
