package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Victory extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Victory frame = new Victory();
					frame.setVisible(true);
					
					GameGUI gm=new GameGUI();
					gm.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Victory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new Home().setVisible(true);
			}
		});
		btnNewGame.setBackground(Color.LIGHT_GRAY);
		btnNewGame.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewGame.setBounds(40, 349, 154, 62);
		contentPane.add(btnNewGame);
		
		JButton btnOver = new JButton("Over");
		btnOver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnOver.setBackground(Color.LIGHT_GRAY);
		btnOver.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnOver.setBounds(505, 349, 154, 62);
		contentPane.add(btnOver);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("E:\\UOB\\Others\\Game_Java\\Resorces\\victory.jpg"));
		lblNewLabel.setBounds(0, 0, 686, 463);
		contentPane.add(lblNewLabel);
	}
}
