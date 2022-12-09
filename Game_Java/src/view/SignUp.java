package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.GamingController;
import model.Game;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.sql.*;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel.setBounds(315, 10, 194, 96);
		contentPane.add(lblNewLabel);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
            if(txtEmail.getText().equals("")||txtPassword.getText().equals("")){
            	  JOptionPane.showMessageDialog(btnSignUp,"Please fill the required Fields");
            	
            }
            
            
            else{
            	GamingController cm=new GamingController();
       		 
       		    Game g=new Game();
                
               g.setEmail( txtEmail.getText());
                 
               g.setPassword( txtPassword.getText());
               
               boolean check=cm.createConnection(g);
               if(check=true) {
            	   
            	   dispose();
   				   new SignIn().setVisible(true);
            	   JOptionPane.showMessageDialog(btnSignUp,"Welcome Your account is sucessfully created");
            	   
               }
               
               else {
            	   
            	   JOptionPane.showMessageDialog(btnSignUp, "This is alredy exist");
               }   
        
            }
            
          }
        });
		btnSignUp.setBounds(326, 313, 162, 52);
		contentPane.add(btnSignUp);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(SystemColor.activeCaption);
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtEmail.setBounds(271, 146, 270, 36);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setForeground(Color.BLACK);
		txtPassword.setToolTipText("Password");
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPassword.setBounds(271, 222, 270, 36);
		contentPane.add(txtPassword);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(271, 113, 96, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(271, 192, 96, 36);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnGoSignIn = new JButton("Sign In");
		btnGoSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new SignIn().setVisible(true);
			}
		});
		btnGoSignIn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnGoSignIn.setBounds(341, 401, 134, 29);
		contentPane.add(btnGoSignIn);
		
		JLabel lblbackgroundimg = new JLabel("New label");
		lblbackgroundimg.setIcon(new ImageIcon("E:\\UOB\\Others\\Game_Java\\Resorces\\SignUp.jpg"));
		lblbackgroundimg.setBounds(0, 0, 786, 463);
		contentPane.add(lblbackgroundimg);
		
	
	}
}
