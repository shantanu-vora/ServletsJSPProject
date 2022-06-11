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
	private String selectQueryById = "select request_status from request_info where id = ?";
	private String updateQuery = "update request_info set request_status = ? where id = ?"; 
	
	
	private Connection getConnection() {
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			
		} catch(SQLException e) {
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
	
	public List fetchRequest() throws SQLException {
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
				String requestStatus = resultSet.getString("request_status");
			
				Request req = new Request(id, fullName, email, message, requestStatus);
				
				requests.add(req);
			}	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
		return requests;
	}
	
	public void updateRequestStatus(Request request) throws SQLException {
		
		Connection connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = getConnection();
			PreparedStatement preparedSelectStatement = connection.prepareStatement(selectQueryById);
			preparedSelectStatement.setInt(1,  request.getId());
			ResultSet resultSet = preparedSelectStatement.executeQuery();
			resultSet.next();
			
			String requestStatus = resultSet.getString("request_status");
			PreparedStatement preparedUpdateStatement = connection.prepareStatement(updateQuery);
			
			if(requestStatus.equals("active")) {
				preparedUpdateStatement.setString(1, "Archive");
				preparedUpdateStatement.setInt(2, request.getId());	
			} else {
				preparedUpdateStatement.setString(1, "active");
				preparedUpdateStatement.setInt(2, request.getId());
			}
			preparedUpdateStatement.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
	
	
}
