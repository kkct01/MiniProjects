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


@WebServlet("/addTeacher")
public class addTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lname = request.getParameter("lname");
		String fname = request.getParameter("fname");
		int class_id = Integer.parseInt(request.getParameter("class_id"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		AdminDao adao = new AdminDao();
		int result;
		try {
			result = adao.addTeacher(lname, fname, class_id, email, phone, password);
		
		if (result > 0) {
			RequestDispatcher rs = request.getRequestDispatcher("editForm.jsp");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			out.println("<p style='color:green;'>New teacher added</p>");
			rs.include(request, response);
		} else {
			RequestDispatcher rs = request.getRequestDispatcher("addNewTeacher.jsp");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			out.println("<p style='color:red;'>Fail to add new teacher, please try again</p>");
			rs.include(request, response);
		}
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
