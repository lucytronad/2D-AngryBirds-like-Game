package model;

import model.entities.Block;
import model.entities.Entity;
import model.entities.Grass;
import model.entities.HummingBird;
import model.entities.Pig;
import model.entities.Pigeon;
import model.entities.Sparrow;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;


public class Level {
	private String backgroundImagePath = "res/images/background.png";
	private Image image;
	private int tabMap[][];
	private int tabMapSizeX = 47;
	private int tabMapSizeY = 22;
	private int blockSize = 26;
	private String grassImagePath = "res/images/grass.png";
	private Image grass;
	private String blockImagePath = "res/images/block.png";
	private Image block;
	private boolean isLoaded;
	private ArrayList<Entity> entities;
	private int pigSpeed;
	
	//constructeur de Level prenant le fichier texte correspondant et la difficulte
	public Level(String fileMapPath, String difficulty) {
		ImageIcon ii = new ImageIcon(backgroundImagePath);
	    image = ii.getImage();
	    ImageIcon gr = new ImageIcon(grassImagePath);
	    grass = gr.getImage();
	    ImageIcon bl = new ImageIcon(blockImagePath);
	    block = bl.getImage();
	   
	    //la vitesse des cochons est fixe en fonction de la difficulte
	    if(difficulty == "easy") pigSpeed=1;
	    if(difficulty == "medium" ) pigSpeed=2;
	    if(difficulty == "hard" ) pigSpeed=3;
	    if(difficulty == "extreme" )pigSpeed=4;
	    
	    entities = new ArrayList<Entity>();
	    
	    //on charge le fichier et on cree les caracteristiques du niveau
	    try
	    {
			FileInputStream ips=new FileInputStream(fileMapPath); 
			isLoaded = true;
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String line;
			line = br.readLine();
			while(!line.equals("Map")) // si la ligne est differente de Map on charge les oiseaux du niveau
			{
				if(line.equals("Pigeon")) // creation d'un pigeon
				{
					entities.add(new Pigeon());
				}
				if(line.equals("Humming Bird")) // creation d'un colibri
				{
					entities.add(new HummingBird());
				}
				if(line.equals("Sparrow")) // creation d'un moineau
				{
					entities.add(new Sparrow());
				}
				line = br.readLine();
			}
			
			//on lit les caracteres du fichier texte un par un et on actualise tabMap
			tabMap = new int[tabMapSizeY][tabMapSizeX];
			
			for(int i=0;i<tabMapSizeY;i++)
			{	
				line = br.readLine();
				
				for(int j=0; j<tabMapSizeX;j++)
				{
					
					char car = line.charAt(j);	
					String st = String.valueOf(car);
					tabMap[i][j]= Integer.parseInt(st);
					if (tabMap[i][j] == 3) //si la case contient un 3 on cree un cochon a la position correspondante
						entities.add(new Pig(j*blockSize,i*blockSize, pigSpeed));
					if(tabMap[i][j] == 2) //si la case contient un 2 on cree un bloc de pierre a la position correspondante
						entities.add(new Block(j*blockSize,i*blockSize,blockSize,blockSize));
					if(tabMap[i][j] == 1) //si la case contient un 1 on cree un bloc d'herbe a la position correspondante
						entities.add(new Grass(j*blockSize,i*blockSize,blockSize,blockSize));
				}
			}		
	    }
	    //si jamais on tente de creer un niveau qui n'a aucun fichier texte correspondant
		catch (Exception e)
		{
			isLoaded = false;
		}   
	}
	public Image getImage() {
        return image;
    }
	public Image getGrass(){
		return grass;
	}
	public Image getBlock(){
		return block;
	}
	public int[][] getTabMap(){
		return tabMap;
	}
	public int getTabMapSizeX(){
		return tabMapSizeX;
	}
	public int getTabMapSizeY(){
		return tabMapSizeY;
	}	
	public int getBlockSize(){
		return blockSize;
	}
	public ArrayList<Entity> getEntityList() {
		return entities;
	}
	
	public boolean isLoaded() {
		return isLoaded;
	}
	
	public void setTabMap(int[][] tabMap) {
		this.tabMap = tabMap;
	}
}
