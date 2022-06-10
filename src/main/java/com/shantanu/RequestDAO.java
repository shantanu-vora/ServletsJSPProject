package com.shantanu;

import java.sql.*;

public class RequestDAO {
	
	private String url = "jdbc:postgresql://localhost:5432/servlets_jsp_project";
	private String username = "postgres";
	private String password = "Lead@123";
	
	private String insertQuery = "insert into request_info (fullname, email, text_message) values (?, ?, ?)";
	
	private Connection getConnection() {
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public void insertRequest(Request request) throws SQLException {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			
			preparedStatement.setString(1, request.getFullName());
			preparedStatement.setString(2, request.getEmail());
			preparedStatement.setString(3, request.getMessage());
			
			preparedStatement.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
}
