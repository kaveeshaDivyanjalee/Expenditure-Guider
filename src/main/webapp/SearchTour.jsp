<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tour Search Result</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="CSS/homeCSS.css">
</head>
<body>
	<body id="top">
<header>
	<nav>
		<div class="logo">
			<h1>Expenditure Guider</h1>
		</div>
        <ul>
            <li><a href="HomePage.jsp">Home</a></li>
            <li><a href="">Tours Calender</a></li>
            <li><a href="">Plan Your Tour</a></li>
            <li><a href="">Tour Guides</a></li>
            
        </ul>
        <div class ="User">
            <img src="Images/img2.png">
            <a href="">Sign In</a>
        </div>
	</nav>
    
</header>
<section class="Result">

    
        
        <c:choose>
        	<c:when test="${empty selectedTour}">
        		<p>No tours found</p>
        	</c:when>
        	<c:otherwise>
        		<c:forEach var="st" items="${selectedTour}">
        		<div class="Detail-main">
		            <div class="search-info">
		                <h2>${st.title}</h2><br><br>
		                <p>${st.description}</p><br>
		                <p><b>Duration:</b>${st.duration}days</p>
		                <p><b>City:</b>${st.city}</p>
		                <p><b>Nearest City:</b>${st.nearCity}</p>
		                <p><b>Cost per person:</b>${st.cost}</p>
		                
		            </div>
		            <div class="search-img1">
		                <img src="data:image/jpeg;base64,${st.coverImage}" alt="cover Image"style="margin-top: 10px;">
		                <br>
		                <button class="book" style="margin-top: 10%;height:30px;background:darkblue;color:white;width:80px"><a href="InsertBooking" style="color:white;text-decoration:none">Book Now</a></button>
		            </div>
		            
		            
		            </div>
		            <hr>
	            </c:forEach>
            </c:otherwise>
        </c:choose>
    
</section>-->
<footer>
    <nav>
		<div class ="paymentMethod">
            <div>
            <img src="Images/visa.png">
            </div>
            <div>
            <img src="Images/master.png">
            </div>
        </div>
            
        <ul>
            <li><a href="HomePage.jsp">Home</a></li>
            <li><a href="">About Us</a></li>
            <li><a href="">Tour Calender</a></li>
            <li><a href="">Tour Guides</a></li>
            <li><a href="">Reviews</a></li>
            <li><a href="">Gallery</a></li>
            
        </ul>
        
	</nav>
    <div class="details1">
        <div class="subDet1">
            <a href="">Privacy & policy </a>
            <span>|</span>
            <a href="">Terms & Conditions </a>
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