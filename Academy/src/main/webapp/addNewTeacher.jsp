<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.service.AdminDao, java.util.ListIterator, com.model.AdminTeacher"%>
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
AdminDao adao = new AdminDao();
ListIterator<AdminTeacher> litr = (adao.printAdminTeacherDetails()).listIterator();
while(litr.hasNext()) {
	out.print(litr.next());
	out.print("<br><br>");
}
%>
<form action="addTeacher" method=post>
<h3>Add a new teacher</h3>
Last name <input type="text" name="lname"><br><br>
First name <input type="text" name="fname"><br><br>
Class ID <input type="text" name="class_id"><br><br>
Email <input type="email" name="email"><br><br>
Phone <input type="text" name="phone"><br><br>
Password <input type="text" name="password"><br><br>
<input type="submit" value="Add new teacher">
</form>
<h3><a href="editForm.jsp">Back</a></h3>
</body>
</html>