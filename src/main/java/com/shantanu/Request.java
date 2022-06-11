package com.shantanu;

public class Request {
	
	
	private int id;
	private String fullName;
	private String email;
	private String message;
	private boolean isActive;

	public Request(int id) {
		this.id = id;
	}
	
	public Request(String fullName, String email, String message) {
		this.fullName = fullName;
		this.email = email;
		this.message = message;
	}

	public Request(int id, String fullName, String email, String message, boolean isActive) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.message = message;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
}
