<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Login</title>
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
        <h1 class="text-center">Login Page</h1>
        <form action="LoginServlet" method="post">
	
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="UserName" name="UserName" placeholder="Enter Username" required>
                <label for="UserName">User Name</label>
            </div>
		
            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                <label for="password">Password</label>
            </div>
		<button type="submit"  class="btn btn-primary mt-3"> Login</button>	
	</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
	
</body>
</html>
