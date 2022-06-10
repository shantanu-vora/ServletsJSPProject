package com.shantanu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/submit")
public class SubmitServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		
		Request req = new Request(fullName, email, message); 
		
		RequestDAO requestDao = new RequestDAO();
		
		try {
			requestDao.insertRequest(req);
			out.println("Your request has been submitted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
