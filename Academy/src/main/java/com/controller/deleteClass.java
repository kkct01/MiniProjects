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


@WebServlet("/deleteClass")
public class deleteClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String class_id = request.getParameter("class_id");
		
		AdminDao adao = new AdminDao();
		int result;
		try {
			result = adao.deleteClass(class_id);
		
		if (result > 0) {
			RequestDispatcher rs = request.getRequestDispatcher("editForm.jsp");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			out.println("<p style='color:green;'>Class deleted</p>");
			rs.include(request, response);
		}else {
			RequestDispatcher rs = request.getRequestDispatcher("deleteClass.jsp");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			out.println("<p style='color:red;'>Fail to delete class, please try again</p>");
			rs.include(request, response);
		}
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	

}
