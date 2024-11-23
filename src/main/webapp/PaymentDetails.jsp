<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Details</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="CSS/homeCSS.css">
    <style>
        
        body {
            font-family: Arial, sans-serif;
            background-color: #e9ecef; 
            color: #333;
            margin: 0;
            padding: 0;
        }

        
        .book-Content {
            width: 80%;
            margin: 50px auto;
            background-color: #ffffff; 
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        
        table.paymentDetails {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
            text-align: left;
            background-color: #fafafa;
        }

        th, td {
            padding: 15px;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        /* Button Styling */
        button.Submit {
            padding: 10px 20px;
            color: white;
            background-color: #4CAF50;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button.Submit:hover {
            background-color: #45a049;
        }

        button.Submit a {
            color: white;
            text-decoration: none;
        }

        button.Submit a:hover {
            text-decoration: underline;
        }

        
        .response form {
            text-align: center;
            margin-bottom: 20px;
        }

        .response button {
            padding: 10px 25px;
            font-size: 16px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .response button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<header>
    <nav>
        <div class="logo">
            <h1>Expenditure Guider</h1>
        </div>
        <ul>
            <li><a href="#">Tours Calendar</a></li>
            <li><a href="#">Plan Your Tour</a></li>
            <li><a href="#">Tour Guides</a></li>
        </ul>
        <div class="User">
            <img src="Images/img2.png" alt="User Icon">
            <a href="#">Sign In</a>
        </div>
    </nav>
</header>

<section class="book-Content">
    <div class="review">
        <div class="response">
            <form action="PaymentDetails" method="post">
                <button type="submit">Check Your Payment Details</button>
            </form>
        </div>
        <table class="paymentDetails">
            <tr>
                <th>PaymentID</th>
                <th>Payment Details</th>
                <th>Status</th>
                <th>Package ID</th>
                <th>Action</th>
            </tr>
            <c:if test="${not empty paymentDetails}">
                <c:forEach var="pay" items="${paymentDetails}">
                    <tr>
                        <td><p>${pay.payID}</p></td>
                        <td>
                            <p>Payment Amount: ${pay.amount}</p>
                            <p>Payment Method: ${pay.paymentMethod}</p>
                            <p>Transaction ID: ${pay.transactionID}</p>
                        </td>
                        <td><p>${pay.status}</p></td>
                        <td><p>${pay.packageID}</p></td>
                        <td>
                            <button class="Submit" onclick="return confirm('Are you sure you want to modify your reservation?')">
                                <a href="PaymentUpdateServlet?paymentID=${pay.payID}">Update Payment</a>
                            </button>
                            <button class="Submit" onclick="return confirm('Are you sure you want to cancel this booking?')">
                                <a href="PaymentDeleteServlet?paymentID=${pay.payID}">Delete Payment</a>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </div>
</section>

<footer>
    <nav>
        <div class="paymentMethod">
            <div><img src="Images/visa.png"></div>
            <div><img src="Images/master.png"></div>
        </div>
        <ul>
            <li><a href="#top">Home</a></li>
            <li><a href="">About Us</a></li>
            <li><a href="">Tour Calendar</a></li>
            <li><a href="">Tour Guides</a></li>
            <li><a href="">Reviews</a></li>
            <li><a href="">Gallery</a></li>
        </ul>
    </nav>
    <div class="details1">
        <div class="subDet1">
            <a href="">Privacy & Policy</a>
            <span>|</span>
            <a href="">Terms & Conditions</a>
        </div>
        <h2>Expenditure Guider</h2>
        <div class="contactlink">
            <a href="#" class="fa fa-facebook"></a>
            <a href="#" class="fa fa-twitter"></a>
        </div>
    </div>
</footer>

</body>
</html>
