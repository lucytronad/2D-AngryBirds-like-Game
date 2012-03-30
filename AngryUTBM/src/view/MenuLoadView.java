package view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

import model.Player;

@SuppressWarnings("serial")
public class MenuLoadView extends GameViewMenu
{
	//declaration des attributs adaptes a la page de chargement de parties
	private JComboBox playersList;
	private JButton okLoadButton, deleteButton;

	public MenuLoadView(ArrayList<Player> players)
	{
        playersList = new JComboBox();
        playersList.setSize(200,30);
        playersList.setLocation(frameWidth/2-100,150);

        //ajout des joueurs dans la JComboBox
        for(Player p : players)
        {
        	playersList.addItem(p);
        }
        
        okLoadButton = new JButton("OK");
        okLoadButton.setSize(200,30);
        okLoadButton.setLocation(frameWidth/2-100, 200);
        
        deleteButton = new JButton("DELETE");
        deleteButton.setSize(200,30);
        deleteButton.setLocation(frameWidth/2-100, 300);
        
        
        //ajout des attributs avec l'index 1 pour etre en premier plan
        this.add(playersList,new Integer(1));
        this.add(deleteButton, new Integer(1));
        this.add(okLoadButton,new Integer(1));
	}
	
	public JComboBox getPlayersList()
	{
		return playersList;
	}
	
	public void setPlayersList(ArrayList<Player> players){
		playersList.removeAllItems();
		for(Player p : players)
        {
        	playersList.addItem(p);
        }
	}
	
	public JButton getDeleteButton()
	{
		return deleteButton;
	}
	
	public JButton getOkLoadButton()
	{
		return okLoadButton;
	}
	
}
