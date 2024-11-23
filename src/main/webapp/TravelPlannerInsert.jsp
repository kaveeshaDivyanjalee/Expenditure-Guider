<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TravelPlanner Registration</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
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
<div class="container mt-5">
        <h1 class="text-center">Register as TravelPlanner</h1>
	<form action="TravelPlannerInsertServlet" method="post" enctype="multipart/form-data">

	    <div class="form-floating mb-3">
	        <input type="text" class="form-control" id="FirstName" name="FirstName" placeholder="First Name" required>
	        <label for="FirstName">First Name</label>
            </div>

            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="LastName" name="LastName" placeholder="Last Name" required>
                <label for="LastName">Last Name</label>
            </div>

            <div class="form-floating mb-3">
                <input type="email" class="form-control" id="email" name="email" placeholder="Email" required>
                <label for="email">Email</label>
            </div>

            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="UserName" name="UserName" placeholder="User Name" required>
                <label for="UserName">User Name</label>
            </div>

            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                <label for="password">Password</label>
            </div>

            <div class="form-floating mb-3">
                <input type="date" class="form-control" id="CreateDate" name="CreateDate" required>
                <label for="CreateDate">Create Date</label>
            </div>

            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="mobile" name="mobile" placeholder="Mobile No" required>
                <label for="mobile">Mobile No</label>
            </div>

            <div class="mb-3">
                <label for="ProfilePic" class="form-label">Profile Picture</label>
                <input class="form-control" type="file" id="ProfilePic" name="ProfilePic" accept="image/*">
            </div>

            <button type="submit" class="btn btn-primary">Register</button>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
