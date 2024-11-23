<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/Feedback.css">
    <title>Feedback Page</title>
</head>
<body style="background-image: url('Images/bk.jpg')">
    <div class="container">
        <div class="form-section">
            <h2>Feedback Form</h2>
            <form id="feedbackForm">
                <label for="id">ID:</label>
                <input type="text" id="id" name="id" required>

                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>

                <label for="feedback">Feedback:</label>
                <textarea id="feedback" name="feedback" required></textarea>

                <button type="submit">Submit Feedback</button>
            </form>
        </div>
        <div class="table-section">
            <h2>Submitted Feedback</h2>
            <table id="feedbackTable">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Feedback</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Feedback entries will be dynamically added here -->
                </tbody>
            </table>
        </div>
    </div>

    <script src="script.js"></script>
</body>
</html>