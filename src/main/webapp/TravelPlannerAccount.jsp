<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TravelPlanner Account</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
	.response{
	display:flex;
	flex-direction:row;
	gap:50px;
	margin:50px 50px 50px 50px;
	}

</style>
<script>
        function showDetails() {
            // Hide the submit button
            document.getElementById("showDetailsButton").style.display = "none";
            // Show the user details
            document.getElementById("userDetails").style.display = "block";
        }
    </script>
</head>
<body>
	
	<div class="container mt-5">
         <form action="TravelPlannerReview" method="post" enctype="multipart/form-data">
            <button type="submit" id="showDetailsButton" onclick="showDetails()">View My Profile</button>
          </form>
     
     
         <form action="UpdateTravelPlannerServlet" method="get" enctype="multipart/form-data">
            <button type="submit" id="showDetailsButton" onclick="showDetails()">Edit My Profile</button>
          </form>
    
    
        
     </div>
     
	<div  id="userDetails" class="table-responsive">
		<table class="table">
		
		<tr>
		<th>User Account</th>
		</tr>
		<c:forEach var="TrvlP" items="${planner}">
		
	
		<tr>
			<td>TravelPlanner UserId</td>
			<td>${TrvlP.userID}</td>
		</tr>
		<tr>
			<td>TravelPlanner UserName</td>
			<td>${TrvlP.userName}</td>
		</tr>
		<tr>
			<td>TravelPlanner password</td>
			<td>${TrvlP.password}</td>
		</tr>
		<tr>
			<td>TravelPlanner email</td>
			<td>${TrvlP.email}</td>
		</tr>
		<tr>
			<td>TravelPlanner FirstName</td>
			<td>${TrvlP.firstName}</td>
		</tr>
		<tr>
	    	<td>TravelPlanner LastName</td>
	    	<td>${TrvlP.lastName}</td>
	    </tr>
	    <tr>
	        <td>TravelPlanner ProfilePic</td>
	        <td>
        	<img src="data:image/png;base64,${TrvlP.profilePic}" alt="Profile Picture" width="100" height="100"/>
    		</td>
	   	</tr>
	   	<tr>
	        <td>TravelPlanner CreateDate</td>
	        <td>${TrvlP.createDate}</td>
	  	</tr>
	  	<tr>
	  	<td>
        <button type="submit" id="showDetailsButton" onclick="showDetails()"><a href="DeletecTravelPlannerServlet?uid=${TrvlP.userID}">Delete Profile</a></button>
          </td>
          </tr>
	
		</c:forEach>
		</table>
	</div>
<!--  	
	<c:url value="UpdateTravelPlannerServlet" var="TrvlPUpdate">
		<c:param name="UserId" value="${UserId}"/>
		<c:param name="UserName" value="${UserName}"/>
		<c:param name="password" value="${password}"/>
		<c:param name="email" value="${email}"/>
		<c:param name="FirstName" value="${FirstName}"/>
		<c:param name="LastName" value="${LastName}"/>
		<c:param name="ProfilePic" value="${ProfilePic}"/>
		<c:param name="CreateDate" value="${CreateDate}"/>
	</c:url>


	<form action="${TrvlPUpdate}" method="post" enctype="multipart/form-data">
	<input type="submit" name="update" value="Update My Data">
	</form>
	
	<br>
	<c:url value="DeleteTravelPlanner.jsp" var="TrvlDelete">
		<c:param name="UserId" value="${UserId}"/>
        <c:param name="UserName" value="${UserName}"/>
        <c:param name="password" value="${password}"/>
        <c:param name="email" value="${email}"/>
        <c:param name="FirstName" value="${FirstName}"/>
        <c:param name="LastName" value="${LastName}"/>
        <c:param name="ProfilePic" value="${ProfilePic}"/>
        <c:param name="CreateDate" value="${CreateDate}"/>
	</c:url>
	<a href="${TrvlDelete}">
	<input type="button" name="delete" value="Delete My Account">
	</a>	-->

</body>
</html>
