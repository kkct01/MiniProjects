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
<form action="deleteTeacher" method=post>
<h3>Remove a teacher</h3>
Please enter a teacher ID to remove <input type="text" name="teacher_id"><br><br>
<input type="submit" value="Remove teacher"><br><br>
</form>
<h3><a href="editForm.jsp">Back</a></h3>
</body>
</html>