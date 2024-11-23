<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="CSS/BookingCss.css">
</head>
<body style="background-image: url('Images/giphy.gif')">
<header>
	<nav>
		<div class="logo">
			<h1>Expenditure Guider</h1>
		</div>
        
        <div class ="User">
            <img src="Images/img2.png">
            <a href="">Sign In</a>
        </div>
	</nav>
    
</header>

<section class="book-Content">
    <div class="menu_icon_box">
        <div class="line1"></div>
        <div class="line2"></div>
        <div class="line3"></div>
    </div>
    <div class="box">
        <div class="nav">
            <ul>
                <li><a href="HomePage.jsp">Home</a></li>
                <li><a href="InsertBooking">New Booking</a></li>
                <li><a href="BookingView.jsp">Delete Your Booking </a></li>
                <li><a href="BookingView.jsp">Search Booking</a></li>
                <li><a href="BookingView.jsp">Update Your Booking</a></li>
                
            </ul>
        </div>
    </div>
    
    <div class="review">

        <div class="response">
            <form action="RetrievBookingServlet" method="post">
            <label>Start Date</label>
            <input type="date" name="start">
            <label>End Date</label>
            <input type="date" name="End">

            <button type="submit">Go</button>
            </form>
        </div>
        <table class="bookDetail">
            <tr>
                <th>BookingID</th>
                <th>Tour detail</th>
                <th>Accomadation</th>
                <th>Guide Details</th>
                <th>Booking Status</th>
                <th>Action</th>
            </tr>
            <c:if test="${not empty booking}">
            	<c:forEach var="book" items="${booking}">
		            <tr>
		                <td>
		                    <p>Booking Id:${book.bookingID}</p>    
		                </td>
		                <td>
		                    <p>Tour Name:${book.tourName}</p>
		                    <p>No.Of Participant :${book.participant}</p>
		                    <p>Booking Date :${book.bookDate}</p>
		                
		                </td>
		                <td>
		                    <p>Hotel Name:${book.hotelName}</p>
		                    <p>Room No :${book.roomNo}</p>
		                    <p>Room Type :${book.roomType}</p>
		                    <p>CheckIn Date :${book.checkIn}</p>
		                	<p>CheckOut Date :${book.checkOut}</p>
		                </td>
		                <td>
		                    <p>Tour Guide Name:${book.guideName}</p>
		                    <p>Vehicle Type :${book.vehicleType}</p>
		                    
		                
		                </td>
		                <td>
		                    <p>pending</p>
		                </td>
		                <td>
		                    <button class="Submit" onclick="return confirm('Are you sure you want to modify your reservation?')"><a href="UpdateBooking?bookingID=${book.bookingID}"><img src="Images/update1.png"></a></button>
		                    <button class="Submit" onclick="return confirm('Are you sure you want to Cancel this booking?')"><a href="DeleteBookingServlet?bookingID=${book.bookingID}"><img src="Images/delete.png"></a></button>
		                </td>
		            </tr>
	            </c:forEach>
            </c:if>
        </table>
    </div>
    
    </section>
<script>


	const confirmMessage="${sessionScope.message}";
	if(confirmMessage){
		alert(confirmMessage);
	}
    let menu_icon_box=document.querySelector(".menu_icon_box");
    let box=document.querySelector(".box");

    menu_icon_box.onclick=function(){
        menu_icon_box.classList.toggle("active");
        box.classList.toggle("active");
    }

    document.onclick=function(e){
        if(!menu_icon_box.contains(e.target) && !box.contains(e.target)){
            menu_icon_box.classList.remove("active");
            box.classList.remove("active");
        }
    }
</script>  
</body>
</html>