package com.lti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lti.model.Users;

public class UserService {
	private Connection conn;
	
	private void openConnection() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		System.out.println("Connected");
		
	}
	private void closeConnection(){
		try{
			conn.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public List<Users> readAllUsers(){
		List<Users> users = null;
		
			try {
				openConnection();
				String query = "Select * From Users";
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(query);
				users = new ArrayList<>();
				while(result.next()){
					String uname = result.getString("Username");
					String password = result.getString("Password");
					
					Users user = new Users(uname, password);
					users.add(user);
			}
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		return users;
	}
	
	
	public int createUser(Users user){
		int result = 0;
		
			try {
				openConnection();
				String query = "Insert Into Users(Username, Password) Values (?, ?)";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, user.getUsername());
				pstmt.setString(2, user.getPassword());
				
				
				result = pstmt.executeUpdate();
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return result;
	}
	
	
}


	
	
	
	
	
	
	


                                                                                                                     