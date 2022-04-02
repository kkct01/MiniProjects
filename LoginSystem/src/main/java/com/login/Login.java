package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		if(name.equalsIgnoreCase("admin") && password.equals("123")) {
		HttpSession session = request.getSession(true);
		session.setAttribute("name", name);
		
		RequestDispatcher rd = request.getRequestDispatcher("Dashboard");
		rd.forward(request, response);
	} else {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		out.println("Invalid user name or password");
		rd.include(request, response);
	}
	}

}
