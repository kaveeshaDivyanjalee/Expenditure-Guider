<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.UserProfile" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Edit Profile</title>
    <link href="CSS/index.css" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $("#editProfileForm").on("submit", function(event) {
                event.preventDefault(); // Prevent the default form submission
                
                $.ajax({
                    url: $(this).attr("action"),
                    type: "POST",
                    data: new FormData(this),
                    processData: false,
                    contentType: false,
                    success: function(response) {
                        // Check if the response indicates a duplicate email
                        if (response.status === "duplicate") {
                            alert("This email is already in use. Please enter a different email.");
                        } else {
                            // If successful, redirect or handle success (e.g., show a success message)
                            window.location.href = "SubmitUserProfile?action=list"; // Change this as needed
                        }
                    },
                    error: function(xhr, status, error) {
                        alert("An error occurred: " + error);
                    }
                });
            });
        });
    </script>
</head>
<body style="background-image: url('Images/bk.jpg')">
    <div class="credit_container">
        <form class="online_form" action="SubmitUserProfile" method="post" enctype="multipart/form-data" id="editProfileForm">
            <h2 class="apy_title bn">Edit Profile</h2>
            <div class="linee"></div>

            <input type="hidden" name="action" value="update">
            <%
                UserProfile profile = (UserProfile) request.getAttribute("profile");
                if (profile != null) {
            %>
                <input type="hidden" name="id" value="<%= profile.getId() %>">
                <div class="fo">
                    <div class="inputer">
                        <label for="first_name" class="label">First Name</label>
                        <input type="text" class="input_section" id="first_name" name="first_name" 
                               value="<%= profile.getFirstName() %>" required />
                    </div>
                    <div class="inputer">
                        <label for="last_name" class="label">Last Name</label>
                        <input type="text" class="input_section" id="last_name" name="last_name" 
                               value="<%= profile.getLastName() %>" required />
                    </div>
                </div>

                <div class="inputer">
                    <label for="email" class="label">Email</label>
                    <input type="email" class="input_section" id="email" name="email" 
                           value="<%= profile.getEmail() %>" required />
                </div>

                <div class="inputer">
                    <label for="password" class="label">Password</label>
                    <input type="password" class="input_section" id="password" name="password" 
                           placeholder="Enter new password (leave blank to keep current)" />
                </div>

                <div class="inputer">
                    <label for="profile_image" class="label">Upload Profile Image</label>
                    <input type="file" class="input_section" id="profile_image" name="profile_image" />
                    <div class="mt-2">
                        <% 
                            String profileImage = profile.getProfileImage();
                            if (profileImage != null && !profileImage.isEmpty()) { 
                        %>
                            <img src="uploads/<%= profileImage %>" alt="Current Profile Image" class="img-thumbnail" width="100">
                        <% } else { %>
                            <p>No current image.</p>
                        <% } %>
                    </div>
                </div>

                <div class="fo">
                    <div class="inputer">
                        <label for="mobile" class="label">Mobile</label>
                        <input type="text" class="input_section" id="mobile" name="mobile" 
                               value="<%= profile.getMobile() %>" required />
                    </div>

                    <div class="inputer">
                        <label for="experience" class="label">Experience</label>
                        <input type="text" class="input_section" id="experience" name="experience" 
                               value="<%= profile.getExperience() %>" required />
                    </div>
                </div>

                <div class="buttone">
                    <button type="submit" class="hj">Update Profile</button>
                </div>
            <%
                } else {
            %>
                <p>Error: Profile data not found.</p>
            <%
                }
            %>
        </form>
    </div>
</body>
</html>
