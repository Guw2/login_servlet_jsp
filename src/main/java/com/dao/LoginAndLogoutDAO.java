package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginAndLogoutDAO {
	
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	// ----- >< ----- //
	
	Statement st;
	Connection con = null;
	
	public LoginAndLogoutDAO() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginusers", "root", "");
	}
	
	public List<String> getAll() throws SQLException{
		List<String> listOfUsers = new ArrayList();
		st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM user");
		while(rs.next()) {
			listOfUsers.add(rs.getString(2));
		}
		return listOfUsers;
	}
	
	public boolean exists(String user) throws SQLException {
		for(String s : getAll()) {
			if(s.equals(user)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean comparePassword(String user, String password) throws SQLException {
		ResultSet rs = st.executeQuery("SELECT password FROM user WHERE username='"+user+"';");
		rs.next();
		rs.getString(1);
		if(rs.getString(1).equals(password)) {
			System.out.println("tacerto");
			return true;
		}else {
			return false;
		}
	}
}
