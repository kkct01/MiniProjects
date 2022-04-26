package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.AdminDao;


@WebServlet("/StaffValidation")
public class StaffValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teacher_email = request.getParameter("teacher_email");
		String teacher_pword = request.getParameter("teacher_pword");
		
		if (teacher_email.equals("admin@academy.com") && teacher_pword.equals("admin@123")) {
			HttpSession session = request.getSession(true);
			session.setAttribute("username", "admin");
			response.sendRedirect("editForm.jsp");
		} 
		else if (teacher_email!="admin@academy.com" && teacher_pword!="admin@123"){
		
		AdminDao adao = new AdminDao();

		try {
			int result = adao.staffValidate(teacher_email, teacher_pword);

			if (result > 0) {
				HttpSession session = request.getSession(true);
				session.setAttribute("teacher_email", teacher_email);
				response.sendRedirect("view_teacher_details.jsp");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				PrintWriter out = response.getWriter();
				response.setContentType("text/html;charset=utf-8");
				out.print("Invalid username or password");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}
		
}
