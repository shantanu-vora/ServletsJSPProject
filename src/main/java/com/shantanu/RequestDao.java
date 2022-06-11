package com.shantanu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDao {
	
	private String url = "jdbc:postgresql://localhost:5432/servlets_jsp_project";
	private String username = "postgres";
	private String password = "Lead@123";
	
	private String insertQuery = "insert into request_info (fullname, email, text_message) values (?, ?, ?)";
	private String selectQuery = "select * from request_info order by id";
	private String selectQueryById = "select is_active from request_info where id = ?";
	private String updateQuery = "update request_info set is_active = ? where id = ?"; 
	
	
	private Connection getConnection() {
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public void insertRequest(Request request) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		try {			
			Class.forName("org.postgresql.Driver");
			connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, request.getFullName());
			preparedStatement.setString(2, request.getEmail());
			preparedStatement.setString(3, request.getMessage());
			
			preparedStatement.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
	
	public List<Request> fetchRequest() throws SQLException {
		Connection connection = null;
		ResultSet resultSet = null;
		List<Request> requests = new ArrayList<>();
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = getConnection();
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String fullName = resultSet.getString("fullname");
				String email = resultSet.getString("email");
				String message = resultSet.getString("text_message");
				boolean isActive = resultSet.getBoolean("is_active");
			
				Request req = new Request(id, fullName, email, message, isActive);
				requests.add(req);
			}	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
		return requests;
	}
	
	public void updateRequestStatus(Request request) throws SQLException, ClassNotFoundException {
		
		Connection connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = getConnection();
			PreparedStatement preparedSelectStatement = connection.prepareStatement(selectQueryById);
			preparedSelectStatement.setInt(1,  request.getId());
			ResultSet resultSet = preparedSelectStatement.executeQuery();
			resultSet.next();
			
			boolean isActive = resultSet.getBoolean("is_active");
			PreparedStatement preparedUpdateStatement = connection.prepareStatement(updateQuery);
			
			if(isActive) {
				preparedUpdateStatement.setBoolean(1, false);
				preparedUpdateStatement.setInt(2, request.getId());	
			} else {
				preparedUpdateStatement.setBoolean(1, true);
				preparedUpdateStatement.setInt(2, request.getId());
			}
			
			preparedUpdateStatement.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
	
	
}
