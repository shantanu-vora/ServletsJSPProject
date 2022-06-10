package com.shantanu;

public class Request {
	private String fullName;
	private String email;
	private String message;
	
	
	
	public Request(String fullName, String email, String message) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.message = message;
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

	
}
