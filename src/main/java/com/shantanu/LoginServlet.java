package com.shantanu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(request, response);
		
//		response.sendRedirect("login.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		
		User user = new User(username, password);
		
		UserDao userDao = new UserDao();
		
		try {
			if(userDao.isValidUsername(user)) {
				if(userDao.isValidPassword(user)) {
					response.sendRedirect("dashboard");
				} else {
					out.println("The password is incorrect");
				}	
			} else {
				out.println("This username does not exist");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
