package view;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MenuHomeView extends GameViewMenu
{
	//declaration des attributs adaptes a la page principale
	private JButton newButton,loadButton,optionsButton,exitButton;
	
	public MenuHomeView() {
		
        newButton = new JButton("NEW GAME");
        newButton.setSize(200,30);
        newButton.setLocation(frameWidth/2-100, 150);
        
        loadButton = new JButton("LOAD GAME");
        loadButton.setSize(200,30);
        loadButton.setLocation(frameWidth/2-100, 225);
        
        optionsButton = new JButton("CONTROLS");
        optionsButton.setSize(200,30);
        optionsButton.setLocation(frameWidth/2-100, 300);
        
        exitButton = new JButton("EXIT GAME");
        exitButton.setSize(200,30);
        exitButton.setLocation(frameWidth/2-100, 375);
        
        backButton.setVisible(false); //pas de bouton de retour sur la page principale
        
        //ajout des attributs avec l'index 1 pour etre en premier plan
   	 	this.add(newButton,new Integer(1));
   	 	this.add(loadButton,new Integer(1));
   	 	this.add(optionsButton,new Integer(1));
   	 	this.add(exitButton,new Integer(1));
	}
	
	public JButton getNewButton()
	{
		return newButton;
	}
	
	public JButton getLoadButton()
	{
		return loadButton;
	}
	
	public JButton getOptionsButton()
	{
		return optionsButton;
	}
	
	public JButton getExitButton()
	{
		return exitButton;
	}
	
}
