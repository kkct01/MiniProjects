<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<h2>Welcome back, Administrator!</h2><br><br>
<h3>Please choose your actions:</h3>
<ul>
<li><h3><a href="addNewClass.jsp">Add a new class</a><br></h3></li>
<li><h3><a href="deleteClass.jsp">Delete a class</a><br></h3></li>
<li><h3><a href="addNewTeacher.jsp">Add a new teacher</a><br></h3></li>
<li><h3><a href="deleteTeacher.jsp">Remove a teacher</a><br></h3></li>
<li><h3><a href="assignClassToTeacher.jsp">Assign teacher to class</a><br></h3></li>
<li><h3><a href="assignSubjectToClass.jsp">Assign subject to class</a><br></h3></li>
<li><h3><a href="studentList.jsp">Generate student master list</a><br></h3></li>
</ul>
<h2><a href="index.html">Home</a></h2><br><br>
<h3><a href="logout.jsp">Logout</a></h3>

</body>
</html>