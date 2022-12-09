package controller;





import java.net.MalformedURLException;
import java.net.URL;

import model.Game;
import view.GameGUI;
import view.Victory;

/**
 * Main class where the games are coming from. 
 * Basic functionality
 */
//attributes name data 

public class GameEngine {
	
	
	String thePlayer = null;

	int counter = 0;
	int score = 0; 
	int level = 1;
	GameServer theGames = new GameServer();
	Game current = null;
	
	/**
	 * Each player has their own game engine.
	 * 
	 * @param player
	 */
	public GameEngine(String player) {
		thePlayer = player;
		
	}


/*
 * Retrieves a game. This basic version only has two games that alternate.
 */
	public URL nextGame() {		
			try {
				current = theGames.getRandomGame();
				return current.getLocation(); 
			} catch (MalformedURLException e) {
				System.out.println("Something went wrong when trying to retrieve game "+counter+"!"); 
				e.printStackTrace();
				return null; 
			} 
		
	}

	/**
	 * Checks if the parameter i is a solution to the game URL. If so, score is increased by one. 
	 * @param game
	 * @param i
	 * @return
	 */
	public boolean checkSolution(URL game, int i) {
		if (i == current.getSolution()) {
			score++; 
			level++; //level increment. 
			
			if (level==5) //level stop. 
			{
			
				score=0;
				level=5;
				Victory v=new Victory();
				v.setVisible(true);
				
				
			    
				
			}
			return true;
		} else {
			return false;
		}
	}

	

	/**
	 * Retrieves the score. 
	 * 
	 * @param player
	 * @return
	 */
	public int getScore() {
		return score;
	}

	public int getLevel() {
		// TODO Auto-generated method stub
		return level;
	}

}
