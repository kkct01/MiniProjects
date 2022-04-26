<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ListIterator, com.service.AdminDao, com.model.AdminClass"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("username")!="admin") {
	response.sendRedirect("index.html");
}
%>

<h3>All current classes</h3>
<%
AdminDao adao = new AdminDao();
ListIterator<AdminClass> litr = (adao.printClassDetails()).listIterator();
while(litr.hasNext()) {
	out.print(litr.next());
	out.print("<br><br>");
}
%>
<form action="assignSubjectToClass" method=post>
<h3>Enter the Class ID that you want to change/assign subject</h3>
Class ID <input type="text" name="class_id"><br>
<h3>Enter the Subject that you want to assign to the class</h3>
Teacher ID <input type="text" name="subject"><br><br>
<input type="submit" value="OK">
</form>
</body>
</html>