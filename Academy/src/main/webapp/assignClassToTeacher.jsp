<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.service.AdminDao, java.util.ListIterator, com.model.AdminTeacher, com.model.AdminClass"%>
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

<h3>All current teachers</h3>
<%
AdminDao adao1 = new AdminDao();
ListIterator<AdminTeacher> litr1 = (adao1.printAdminTeacherDetails()).listIterator();
while(litr1.hasNext()) {
	out.print(litr1.next());
	out.print("<br><br>");
}
%>

<h3>All current classes</h3>
<%
AdminDao adao2 = new AdminDao();
ListIterator<AdminClass> litr2 = (adao2.printClassDetails()).listIterator();
while(litr2.hasNext()) {
	out.print(litr2.next());
	out.print("<br><br>");
}
%>
<form action="assignClassToTeacher" method=post>
<h3>Enter the Class ID that you want to change/assign teacher</h3>
Class ID <input type="text" name="class_id"><br>
<h3>Enter the Teacher ID that you want to assign to the class</h3>
Teacher ID <input type="text" name="teacher_id"><br><br>
<input type="submit" value="OK">
</form>
</body>
</html>