package com.shantanu;

public class Request {
	
	
	private int id;
	private String fullName;
	private String email;
	private String message;
	private String requestStatus;

	public Request(int id) {
		this.id = id;
	}
	
	public Request(String fullName, String email, String message) {
		this.fullName = fullName;
		this.email = email;
		this.message = message;
	}

	public Request(int id, String fullName, String email, String message, String requestStatus) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.message = message;
		this.requestStatus = requestStatus;
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
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}





//	@Override
//	public String toString() {
//		return "Request [fullName=" + fullName + ", email=" + email + ", message=" + message + ", requestStatus="
//				+ requestStatus + "]";
//	}

	
	
}
