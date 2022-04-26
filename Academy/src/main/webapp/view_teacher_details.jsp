<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.service.AdminDao, com.model.Teacher"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String tid = (String)session.getAttribute("teacher_email");
if (tid==null) {
	response.sendRedirect("index.html");
}

AdminDao adao = new AdminDao();
Teacher teacher = adao.printTeacherDetails(tid);
%>

<h3>Hello Teacher, here is your details:</h3><br>
<%out.println(teacher);%>

<h3><a href="index.html">Home</a></h3><br><br>
<h3><a href="logout.jsp">Logout</a></h3>

</body>
</html>