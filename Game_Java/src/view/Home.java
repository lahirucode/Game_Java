package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Math Quiz Game");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel.setBounds(214, 30, 383, 61);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new GameGUI().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(281, 114, 232, 30);
		contentPane.add(btnNewButton);
		
		JButton btnResume = new JButton("Resume");
		btnResume.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnResume.setBounds(281, 166, 232, 30);
		contentPane.add(btnResume);
		
		JButton btnScoreboard = new JButton("Scoreboard");
		btnScoreboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnScoreboard.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnScoreboard.setBounds(281, 221, 232, 30);
		contentPane.add(btnScoreboard);
		
		JButton btnMyProfile = new JButton("My Profile");
		btnMyProfile.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnMyProfile.setBounds(281, 272, 232, 30);
		contentPane.add(btnMyProfile);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnExit.setBounds(556, 374, 140, 30);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\UOB\\Others\\Game_Java\\Resorces\\SignUp.jpg"));
		lblNewLabel_1.setBounds(0, 0, 786, 463);
		contentPane.add(lblNewLabel_1);
	}
	

}
