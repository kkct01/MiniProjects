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

import com.service.AdminDao;


@WebServlet("/assignSubjectToClass")
public class assignSubjectToClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String class_id = request.getParameter("class_id");
		String subject = request.getParameter("subject");
		AdminDao adao = new AdminDao();
		int result;
		try {
			result = adao.assignSubjectToClass(class_id, subject);

			if (result > 0) {
				RequestDispatcher rd = request.getRequestDispatcher("editForm.jsp");
				PrintWriter out = response.getWriter();
				response.setContentType("text/html;charset=utf-8");
				out.println("<p style='color:green;'>Assign subject to class success</p>");
				rd.include(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("assignClassToTeacher.jsp");
				PrintWriter out = response.getWriter();
				response.setContentType("text/html;charset=utf-8");
				out.println("<p style='color:red;'>Assign subject to class failed</p>");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
