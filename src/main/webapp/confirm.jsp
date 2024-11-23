<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Booking</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="CSS/BookingCss.css">
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
    <div class="message">
        <h1>You have 50% Complete successfully.</h1>
        <p>Your Booking ID : ${id}</p>
        <p>Now You can Enter the Booking proceess......</p>
        <div class="pay">
            <button><a href="PaymentInsert.jsp">Make Payment</a></button>
            </div>
    </div>
    
    </section>
<script>
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