package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Dashboard() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String name = (String)session.getAttribute("name");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		out.print("<h2>Welcome to the dashboard</h2><br>");
		out.print("User: " + name + "<br><br>");
		out.print("<a href='index.html'>Return to Login</a>");
		
	}

}
