<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="Model.Tour" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
   

    	
	<!-- <% List<Tour> tours = (List<Tour>) request.getAttribute("selectedTour"); %>-->
	<% String category = (String) request.getAttribute("catName"); %>
        
     <c:choose>
     	<c:when test="${empty selectedTour}">
     		<p>No tours found</p>
     	</c:when>
     	<c:otherwise>
     		<div class="tourLis">
	    		<div class="topic">
	    		<h2 style="color:#006064"><%=category.substring(0,1).toUpperCase()+category.substring(1) %> Tours</h2>
	    		</div>
	    		<c:forEach var="st" items="${selectedTour}">
	    		<div class="Detail-main" style="background-color:rgba(255,255,255,0.6);margin-left:5px;padding:20px 20px 10px 20px;display:flex;flex-direction:row">
	          	  <div class="search-info">
		              <h2 style="color:#006064;paddding:2%">${st.title}</h2><br><br>
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
          </div>
         </c:otherwise>
        </c:choose>
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