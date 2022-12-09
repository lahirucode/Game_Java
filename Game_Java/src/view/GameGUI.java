package view;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

import controller.GameEngine;
import java.awt.FlowLayout;
import javax.swing.Timer;
import java.text.DecimalFormat;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;


/**
 * A Simple Graphical User Interface for the Six Equation Game.
 * 
 * @author Marc Conrad
 *
 */
public class GameGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -107785653906635L;

	int count=0;
	@Override
	public void actionPerformed(ActionEvent e) {
		int solution = Integer.parseInt(e.getActionCommand()); //Solution
		boolean correct = myGame.checkSolution(currentGame, solution); //get an image as a question. 
		int score = myGame.getScore();
		int level = myGame.getLevel();
		
		if (correct) {
			System.out.println("YEAH!");
			currentGame = myGame.nextGame(); 
			ImageIcon ii = new ImageIcon(currentGame); 
			questArea.setIcon(ii);
			infoArea.setText("Good!  Score: "+score); 
			//Display the Level
			lblLevel.setText("Level: "+ level );
			//Reset the timer 
			countDownTimer(20);
 		    timer.start();
 		    timer.stop();
 		    count+=1;
			stopTimer(count);
			if(level==5) {
				dispose();
			}
			
			
			
	
		} else { 
			System.out.println("Incorrect Answer"); 
			infoArea.setText("Oops. Try again!  Score: "+score);
		}
	}

	JLabel lblLevel = new JLabel("Level: 1");
	//JLabel lblTimer = new JLabel("Timer");
	
	JLabel questArea = null;
	GameEngine myGame = null;
	URL currentGame = null;
	JTextArea infoArea = null;
	
	//Timer
	
	Timer timer;
	int second = 0;
	int minute = 4;
	String ddSecond, ddMinute;
	DecimalFormat dFormat = new DecimalFormat("00");
	JLabel lblTimer = new JLabel("Timer");
/**
 * Initializes the game. 
 * @param player
 */
	private void initGame(String player) {
		setSize(690, 548);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("What is the missing value?");
		JPanel panel = new JPanel();
		panel.setBounds(0, 67, 676, 444);

		myGame = new GameEngine(player);//Object myGame. 
		currentGame = myGame.nextGame();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		infoArea = new JTextArea(1, 40);
		
		infoArea.setEditable(false);
		infoArea.setText("What is the missing value?   Score: 0");
		
		JScrollPane infoPane = new JScrollPane(infoArea);
		panel.add(infoPane);

		ImageIcon ii = new ImageIcon(currentGame);
		questArea = new JLabel(ii);
		questArea.setBackground(new Color(102, 153, 204));
	    questArea.setSize(330, 600);
	    
		JScrollPane questPane = new JScrollPane(questArea);
		panel.add(questPane);

		for (int i = 0; i < 10; i++) {
			JButton btn = new JButton(String.valueOf(i));
			panel.add(btn);
			btn.addActionListener(this);
		}
		getContentPane().setLayout(null);

		getContentPane().add(panel);
		
		lblLevel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		

		lblLevel.setBounds(506, 14, 102, 43);
		getContentPane().add(lblLevel);
		
		
		lblTimer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTimer.setBounds(261, 11, 131, 48);
		getContentPane().add(lblTimer);
		panel.repaint();

		lblTimer.setText("Time: 04:00");
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new Home().setVisible(true);
			}
		});
		btnBack.setBackground(new Color(100, 149, 237));
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBack.setBounds(36, 14, 90, 45);
		getContentPane().add(btnBack);
	}
/**
 * Default player is null. 
 */
	public GameGUI() {
		super();
		getContentPane().setBackground(new Color(176, 196, 222));
		initGame(null);
		countDownTimer(0);
		timer.start();
	}

	/**
	 * Use this to start GUI, e.g., after login.
	 * 
	 * @param player
	 */


	/**
	 * Main entry point into the equation game.
	 * 
	 * @param args not used.
	 */
	public static void main(String[] args) {
		GameGUI myGUI = new GameGUI();
		myGUI.setVisible(true);

	}
	
	//Timer Method. 
	public void countDownTimer(int reduceValue) {
		
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				second--;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);	
				lblTimer.setText("Time: "+ddMinute + ":" + ddSecond);
				
				if(second==-1) {
					second = 59;
					minute--;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);	
					lblTimer.setText("Time: "+ddMinute + ":" + ddSecond);
				}
				if(minute==0 && second==0) {
					timer.stop();
					dispose();
					new Home().setVisible(true);
				}
			}
		});		
	}
	
	public void stopTimer(int count) {
		
		
		second = 59;
		minute = 3-count;
		timer.stop();
	}
}