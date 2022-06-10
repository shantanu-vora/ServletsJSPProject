package com.shantanu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDao requestDao = new RequestDao();
		
		List<Request> list = null;
		try {
			list = requestDao.fetchRequest();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("requestList", list);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
		requestDispatcher.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int requestId = Integer.parseInt(request.getParameter("reqId"));
		
		Request req = new Request(requestId);
		RequestDao requestDao = new RequestDao();
		
		try {
			requestDao.updateRequestStatus(req);
			doGet(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
