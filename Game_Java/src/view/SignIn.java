package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.GamingController;
import model.Game;




public class SignIn extends JFrame {

	private JPanel contentPane;
	private JTextField txtInEmail;
	private JPasswordField txtInPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
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
	public SignIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSignIn = new JLabel("Sign In");
		lblSignIn.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblSignIn.setBounds(325, 20, 194, 96);
		contentPane.add(lblSignIn);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(271, 123, 96, 36);
		contentPane.add(lblNewLabel_1);
		
		txtInEmail = new JTextField();
		txtInEmail.setForeground(SystemColor.activeCaption);
		txtInEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtInEmail.setColumns(10);
		txtInEmail.setBounds(271, 156, 270, 36);
		contentPane.add(txtInEmail);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(271, 202, 96, 36);
		contentPane.add(lblNewLabel_1_1);
		
		txtInPassword = new JPasswordField();
		txtInPassword.setToolTipText("Password");
		txtInPassword.setForeground(Color.BLACK);
		txtInPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtInPassword.setBounds(271, 232, 270, 36);
		contentPane.add(txtInPassword);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SignInUser();
			}
		});
		btnSignIn.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnSignIn.setBounds(325, 299, 162, 52);
		contentPane.add(btnSignIn);
		
		JButton btnNewButton = new JButton("Create New Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new SignUp().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(292, 385, 227, 28);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\UOB\\Others\\Game_Java\\Resorces\\SignUp.jpg"));
		lblNewLabel.setBounds(0, 0, 786, 463);
		contentPane.add(lblNewLabel);
		
		
	}
	
	public void SignInUser() {
		GamingController cm=new GamingController();
		 
		 Game g=new Game();
	     g.setEmail(txtInEmail.getText());
	     g.setPassword(txtInPassword.getText());
		boolean check=cm.getConnection(g);
		if(check==true) {
			Home h=new Home();
			h.setVisible(true);
			this.setVisible(false);
			
		}else {
			
			JOptionPane.showMessageDialog(null, "Username or Password is Incorrect", "Error" , JOptionPane.ERROR_MESSAGE);
		}
		
	}
		
		
	
}
