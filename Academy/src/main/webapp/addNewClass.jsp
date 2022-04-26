<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.service.AdminDao, java.util.ListIterator, com.model.AdminClass"%>
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
<form action="addClass" method=post>
<h3>Add a new class</h3>
Subject <input type="text" name="subject"><br><br>
Start Date <input type="date" name="start_date"><br><br>
End Date <input type="date" name="end_date"><br><br>
Teacher ID <input type="text" name="teacher_id"><br><br>
<input type="submit" value="Add new class">
</form>
<h3><a href="editForm.jsp">Back</a></h3>
</body>
</html>