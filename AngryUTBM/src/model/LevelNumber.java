package model;

import java.io.File;

public class LevelNumber {
	static public int getLevelNumber() {
		int levelNumber = 0;
		
		try{
			File initial = new File ("res/maps");
			levelNumber = initial.listFiles().length;
		}
		catch(Exception e)
		{
			//message d'exception
		}
		
		return levelNumber;
	}
}
