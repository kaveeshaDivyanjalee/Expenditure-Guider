<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookingUI</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="CSS/BookingCss.css">
 <script>
        
        function loadHotels() {
            const tourName = document.getElementById('tourSelect').value;

            if (tourName) {
                fetch('InsertBooking?tours=' + encodeURIComponent(tourName))
                    .then(response => response.text())
                    .then(data => {
                        const hotelSelect = document.getElementById('hotelSelect');
                        hotelSelect.innerHTML = data;
                    })
                    .catch(error => console.error('Error:', error));
            } else {
                
                document.getElementById('hotelSelect').innerHTML = '<option value="">Select Hotel</option>';
            }
        }
    </script>
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
    <div class="title">
        <h1>Book Your Dream Tour</h1>
        <div class="form-sec">
            <form action="InsertBooking" method="post">
                <div class="inputField">
                <!-- show all the tours in the data base -->
                    <label name="tour" id="tourSelect" >Tour</label>
                    <select name="tours" id="tourSelect" onchange="this.form.action='InsertBooking'; this.form.method='GET'; this.form.submit();" >
                        <option value="">Select Tour</option>
                        <c:forEach var="tour" items="${tourTitle}">
                        	<option value="${tour}"${tour eq param.tours ? 'selected' : ''}>${tour}</option>
                        </c:forEach>
                    </select>
                    
                </div>
                
               <div class="inputField">
                <label name="TourDate">Tour Date:</label>
                <input type="date" name="tourDate" id="TourDate">
               </div>
              
               <div class="inputField">
                <label name="mobilenum">Mobile Number:</label>
                <input type="text" name="mobile" required>
               </div>
               <div class="inputField">
                <label name="email">email:</label>
                <input type="email" name="mail" required>
               </div>
               <div class="inputField">
                <label name="label">Do you want tour guide? </label>
                        <div class="radio-group">
                            <label><input type="radio" name="choice" value="yes">Yes</label>
                            <label><input type="radio" name="choice" value="no">No</label>
                            
                        </div>
               </div>
               <div class="inputField">
                <label name="label">Do you want Vehicle for tour? </label>
                <div class="radio-group">
                    <label><input type="radio" name="vehicle" value="yes">Yes</label>
                    
                    <label><input type="radio" name="vehicle" value="no">No</label>
                    
                </div>
               </div>
               <div class="inputField">
                    <label name="label">Vehicle Type </label>
                    <select name="vType">
                        <option value="">Select Vehicle Type</option>
                        <option value="Minivan">Minivan</option>
                        <option value="Van">Van</option>
                        <option value="Bus">Bus/Coach</option>
                        <option value="motorBike">Motorbike</option>
                        <option value="bicycle">Bicycle</option>
                        <option value="jeep">Jeep</option>
                        <option value="car">Luxury Car</option>
                    </select>
                    
                </div>
                <div class="inputField">
                    <label name="label">Max Participant </label>
                    <input type="text" name="member" required>
                   
                    
                </div>
               <div class="Accomadation">
               <div name="inputField">
                    <label name="label">Hotel </label>
                    <select name="hotelAcc">
                        <option value="">Select Hotel</option>
                        <c:forEach var="hName" items="${hotel}">
                        	<option value="${hName}">${hName}</option>
                        </c:forEach>
                       
                    </select>
                    
                </div>
                <div class="inputField">
                    <label name="label">Room Type </label>
                    <select name="roomtype">
                        <option value="">select Room Type</option>
                        <option value="single">single</option>
                        <option value="double">double</option>
                        <option value="Queen">Queen</option>
                        <option value="cabana">Cabana</option>
                        <option value="Smoking">Smoking</option>
                        <option value="king">King</option>
                        <option value="noSmoking">Non-Smoking</option>
                    </select>
                    
                </div>
                </div>
                <div class="inputField">
                <label name="CheckIn">Check In Date</label>
                <input type="date" name="CheckIn" id="CheckIn">
               </div>
               <div class="inputField">
                <label name="CheckOut">Check Out Date</label>
                <input type="date" name="CheckOut" id="CheckOut">
               </div>
                
                <div class="btn">
                    <button type="submit">Book tour</button>
                </div>
               
            </form>
        </div>
    </div>

</section> 
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
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