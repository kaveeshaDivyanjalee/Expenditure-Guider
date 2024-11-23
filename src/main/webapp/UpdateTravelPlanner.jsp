<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.io.InputStream" %> 
<%@ page import="java.io.ByteArrayOutputStream" %> 
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Base64" %>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="java.time.format.DateTimeParseException"%>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel = "stylesheet" href = "CSS/bootstrap.min.css">
<title>Insert title here</title>
<style type="text/css">
		table {
  			border-collapse: collapse;
		}

		table, th, td {
		  border: 1px solid black;
		}
	</style>

</head>
<body style="background-image: url('Images/giphy.gif') ba">



	<form action="UpdateTravelPlannerServlet" method="post" enctype="multipart/form-data">
	<table>
		
		<c:forEach var="TrvlP" items="${planner}">
		<tr>
			<td>First Name</td>
			<td><input type="text" name="FirstName" value="${TrvlP.firstName}"></td>
		</tr>
		<tr>
		<td>Last Name</td>
		<td><input type="text" name="LastName" value="${TrvlP.lastName}"></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><input type="email" name="email" value="${TrvlP.email}"></td>
	</tr>
	<tr>
		<td>User Name</td>
		<td><input type="text" name="UserName" value="${TrvlP.userName}"></td>
	</tr>	
	<tr>
		<td>Password</td>
		<td><input type="password" name="password" value="${TrvlP.password}"></td>
	</tr>		
	<tr>
		<td>Create Date</td>
		<td><input type="date" name="CreateDate" value="${TrvlP.createDate}"></td>
	</tr>	
	<tr>
		<td>Profile Picture</td>
		<td><input type="file" name="ProfilePic"></td>
	</tr>	
	</c:forEach>
	</table>
	<br>        		
		<input type="submit" name="submit" value="Update My Data">
	</form>
	
	

</body>
</html>