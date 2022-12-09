package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.Game;
import view.Home;
import view.SignIn;

//create database connections. 
public class GamingController {
	
	public boolean  getConnection(Game g) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mathjava","root","");
			
			java.sql.Statement stm = con.createStatement();
			String sql = "Select * from users where email = '" + g.getEmail() + "' and password = '" + g.getPassword()+ "'"; 
			ResultSet rs = stm.executeQuery(sql);
			
			if (rs.next()) {
				con.close();
				return true;
				
				 
			}else {
				
				 return false;
				
			}
			
		}catch (Exception el) {
			System.out.println(el);
			return false;
		}
	}
	
	public boolean  createConnection(Game g) {
			
		try {
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mathjava", "root", "");
	
	        String query = "INSERT INTO users values('" + g.getEmail() + "','" +g.getPassword() + "')";
	
	        java.sql.Statement sta = connection.createStatement();
	        int x = sta.executeUpdate(query);
	        if (x == 0) {
	        	connection.close();
	            return false;
	        } else {
	        	
	        	 
				 return true;
	        }
	        
	    } catch (Exception exception) {
	    	
	        exception.printStackTrace();
	        return false;
	    }
	}

}
