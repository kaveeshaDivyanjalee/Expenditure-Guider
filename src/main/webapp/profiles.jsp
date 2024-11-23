<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.UserProfile" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>User Profiles</title>
    <style>
        body {
            background-image: url('images/background.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            height: 100vh;
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center">User Profiles</h2>

    <table class="table table-bordered table-hover mt-4">
        <thead class="thead-light">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Experience</th>
                <th>Profile Image</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<UserProfile> profiles = (List<UserProfile>) request.getAttribute("profiles");
            if (profiles != null) {
                for (UserProfile profile : profiles) {
        %>
            <tr>
                <td><%= profile.getId() %></td>
                <td><%= profile.getFirstName() %></td>
                <td><%= profile.getLastName() %></td>
                <td><%= profile.getEmail() %></td>
                <td><%= profile.getMobile() %></td>
                <td><%= profile.getExperience() %></td>
                <td>
                    <img src="uploads/<%= profile.getProfileImage() %>" alt="Profile Image" class="img-thumbnail" width="50" height="50"/>
                </td>
                <td style="display:flex;gap:10px">
                    <a href="SubmitUserProfile?action=edit&id=<%= profile.getId() %>" class="btn btn-primary btn-sm">Edit</a>
                    <a href="SubmitUserProfile?action=delete&id=<%= profile.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this profile?');">Delete</a>
                </td>
            </tr>
        <%
                }
            } else {
                out.println("<tr><td colspan='8' class='text-center'>No profiles found.</td></tr>");
            }
        %>
        </tbody>
    </table>
    <a href="userProfileForm.jsp" class="btn btn-success">Add New Profile</a>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
