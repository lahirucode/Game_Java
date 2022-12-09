package model;





import java.net.URL;
//model game 
public class Game {
	URL location = null; 
	int solution = -1;
	private String email;
	private String password;
	
	//OOP concetps:-  encapsulation.  
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Location of the game and what is the solution to the game.
	 * @param location
	 * @param solution
	 */
	//constructors through values assign. 
	public Game() {}
	public Game(URL location, int solution) {
		super();
		this.location = location;
		this.solution = solution;
	}
	/**
	 * The location of the game. 
	 * @return the location of the game.
	 */
	public URL getLocation() {
		return location;
	}

	/**
	 * @return The solution of the game.
	 */
	public int getSolution() {
		return solution;
	}
	
	
	
	

}
