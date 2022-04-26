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

@WebServlet("/Validation")
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String student_email = request.getParameter("student_email");
		String student_pword = request.getParameter("student_pword");
		AdminDao adao = new AdminDao();

		try {
			int result = adao.validate(student_email, student_pword);

			if (result > 0) {
				HttpSession session = request.getSession(true);
				session.setAttribute("student_email", student_email);
				response.sendRedirect("view_student_details.jsp");
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
