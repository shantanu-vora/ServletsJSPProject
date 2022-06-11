package com.shantanu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		
		User user = new User(username, password);
		UserDao userDao = new UserDao();
		
		try {
			if(userDao.isValidUsername(user)) {
				if(userDao.isValidPassword(user)) {
					HttpSession session = request.getSession();
					session.setAttribute("username", username);
					response.sendRedirect("dashboard");
				} else {
					response.sendRedirect("login");
				}	
			} else {
				response.sendRedirect("login");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
