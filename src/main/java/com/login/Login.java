package com.login;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.LoginAndLogoutDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@WebServlet("/Login")
public class Login extends HttpServlet {

	LoginAndLogoutDAO dao;
	
	{
		try {
			dao = new LoginAndLogoutDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		try {
			if(dao.exists(username) && dao.comparePassword(username, password)) {
				HttpSession session = request.getSession();
				session.setAttribute("USER", username);
				
				response.sendRedirect("welcome.jsp");
			}else {
				response.sendRedirect("login.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}
