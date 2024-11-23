<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Upload Profile</title>
    <link href="CSS/index.css" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        body {
            background-image: url('images/background.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            height: 100vh;
        }
    </style>
    <script>
        $(document).ready(function () {
            $('form').on('submit', function (e) {
                e.preventDefault(); // Prevent default form submission
                const email = $('[name="email"]').val();
                
                // Rest of the form validation...
                
                // Check for duplicate email
                $.ajax({
                    url: 'CheckEmailServlet', // Assuming CheckEmailServlet exists
                    type: 'POST',
                    data: { email: email },
                    success: function (data) {
                        if (data.exists) {
                            alert('Email already exists. Please use a different email.');
                        } else {
                            // Submit the form if the email is unique
                            $('form')[0].submit();
                        }
                    },
                    error: function () {
                        alert('Error checking email. Please try again.');
                    }
                });
            });
        });
    </script>
</head>
<body style="background-image: url('Images/bk.jpg')">
	<div class="credit_container">
		<form action="SubmitUserProfile" method="post"
			enctype="multipart/form-data" class="online_form">
			<input type="hidden" name="action" value="create" />
			<h2 class="apy_title bn">Create Profile</h2>
			<div class="linee"></div>

			<div class="fo">
				<div class="inputer">
					<label for="first_name" class="label">First Name</label> <input
						type="text" name="first_name" class="input_section" required />
				</div>
				<div class="inputer">
					<label for="last_name" class="label">Last Name</label> <input
						type="text" name="last_name" class="input_section" required />
				</div>
			</div>

			<div class="inputer">
				<label for="email" class="label">Email</label> <input type="email"
					name="email" class="input_section" required />
			</div>

			<div class="inputer">
				<label for="profile_image" class="label">Upload Profile
					Image</label> <input type="file" name="profile_image" class="input_section"
					accept="image/*" required />
			</div>

			<div class="inputer">
				<label for="mobile" class="label">Mobile</label> <input type="text"
					name="mobile" class="input_section" required />
			</div>

			<div class="inputer">
				<label for="mobile" class="label">Password</label> <input
					type="password" name="password" class="input_section" required />
			</div>

			<div class="inputer">
				<label for="experience" class="label">Experience</label> <select
					name="experience" class="input_section" required>
					<option value="" disabled selected>Select your experience
						level</option>
					<option value="Beginner">Beginner</option>
					<option value="Intermediate">Intermediate</option>
					<option value="Expert">Expert</option>
				</select>
			</div>

			<div class="buttone">
				<button type="submit" class="hj">SUBMIT</button>
			</div>
		</form>
	</div>
</body>
</html>
