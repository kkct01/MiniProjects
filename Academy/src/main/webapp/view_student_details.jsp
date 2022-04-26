<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.service.AdminDao, com.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student details</title>
</head>
<body>

<%
String stud_id = (String)session.getAttribute("student_email");
if (stud_id==null) {
	response.sendRedirect("index.html");
}

AdminDao adao = new AdminDao();
Student student = adao.printStudentDetails(stud_id);
%>

<h3>Dear Student, here is your details:</h3><br>
<%out.println(student);%>

<h3><a href="index.html">Home</a></h3><br><br>
<h3><a href="logout.jsp">Logout</a></h3>

</body>
</html>