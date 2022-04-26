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
<form action="deleteClass" method=post>
<h3>Delete a class</h3>
Please enter a class ID to delete <input type="text" name="class_id"><br><br>
<input type="submit" value="Delete class"><br><br>
</form>
<h3><a href="editForm.jsp">Back</a></h3>
</body>
</html>