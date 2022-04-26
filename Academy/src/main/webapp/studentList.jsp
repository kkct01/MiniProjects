<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.service.AdminDao, java.util.ListIterator, com.model.AdminStudent"%>
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
<h3>Student Master List</h3>
<%
AdminDao adao = new AdminDao();
ListIterator<AdminStudent> litr = (adao.printAdminStudentDetails()).listIterator();
while(litr.hasNext()) {
	out.print(litr.next());
	out.print("<br><br>");
}
%>

<h3><a href="editForm.jsp">Back</a></h3>
</body>
</html>