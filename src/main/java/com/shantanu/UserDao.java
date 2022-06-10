package com.shantanu;

import java.sql.*;

public class UserDao {

	private String url = "jdbc:postgresql://localhost:5432/servlets_jsp_project";
	private String username = "postgres";
	private String password = "Lead@123";
	
	private String selectQuery = "select * from users where username = ?";
	
	private Connection getConnection() {
		
		Connection connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	
	public boolean isValidUsername(User user) throws SQLException {
		Connection connection = null;
		boolean isValid = true;
		try {
			Class.forName("org.postgresql.Driver");
			connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, user.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();
		
			isValid = resultSet.next();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return isValid;
	}
	
	
	public boolean isValidPassword(User user) throws SQLException {
		Connection connection = null;
		boolean isValid = true;
		try {
			Class.forName("org.postgresql.Driver");
			connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, user.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			isValid = resultSet.getString("password").equals(user.getPassword());
				
		} catch(Exception e) {
			e.printStackTrace();
		} 
		
		return isValid;
	}
}



