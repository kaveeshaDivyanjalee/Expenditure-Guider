<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.io.InputStream" %> 
<%@ page import="java.io.ByteArrayOutputStream" %> 
<%@ page import="java.io.IOException" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<style>
        body {
            background-image: url('Images/Background.jpg');
            background-size: cover;
            background-repeat: no-repeat; 
            background-position: center;
        }
</style>
</head>
<body>
<%	
    String UserId = request.getParameter("UserId");
    String UserName = request.getParameter("UserName");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
    String FirstName = request.getParameter("FirstName");
    String LastName = request.getParameter("LastName");
    Part filePart = request.getPart("ProfilePic");
    byte[] ProfilePic = null;
    if (filePart != null) {
    	try (InputStream inputStream = filePart.getInputStream();
   	         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

   	        byte[] buffer = new byte[1024];
   	        int bytesRead;
   	        while ((bytesRead = inputStream.read(buffer)) != -1) {
   	            byteArrayOutputStream.write(buffer, 0, bytesRead);
   	        }

   	        ProfilePic = byteArrayOutputStream.toByteArray();
   	    } catch (IOException e) {
   	        e.printStackTrace(); 
   	    }
    }
    String createDateString = request.getParameter("CreateDate");
    Date CreateDate = Date.valueOf(createDateString); // Convert to java.sql.Date
    %>
	
    <div class="container mt-5">
        <h1 class="text-center">Delete TravelPlanner Account</h1>
	<form action="delete" method="post" enctype="multipart/form-data">

            <div class="mb-3">
                <label for="UserId" class="form-label">User ID</label>
                <input type="text" class="form-control" id="UserId" name="UserId" value="<%= UserId %>" readonly>
            </div>

            <div class="mb-3">
                <label for="FirstName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="FirstName" name="FirstName" value="<%= FirstName %>" readonly>
            </div>

            <div class="mb-3">
                <label for="LastName" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="LastName" name="LastName" value="<%= LastName %>" readonly>
            </div>

            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" value="<%= email %>" readonly>
            </div>

            <div class="mb-3">
                <label for="UserName" class="form-label">User Name</label>
                <input type="text" class="form-control" id="UserName" name="UserName" value="<%= UserName %>" readonly>
            </div>

            <div class="mb-3">
		<label for="CreateDate" class="form-label">Create Date</label>
                <input type="date" class="form-control" id="CreateDate" name="CreateDate" value="<%= CreateDate %>" readonly>
            </div>

	    <div class="mb-3">
                <label for="ProfilePic" class="form-label">Profile Picture</label>
                <input type="date" class="form-control" id="ProfilePic" name="ProfilePic" value="<%= ProfilePic %>" readonly>
            </div>

	    <button type="submit" class=class="btn btn-primary mt-3">Delete My Account</button>
        </form>
</div>


</body>
</html>
