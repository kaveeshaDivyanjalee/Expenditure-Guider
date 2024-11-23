<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="CSS/homeCSS.css">
</head>
<body>
	<header>
	<nav>
		<div class="logo">
			<h1>Expenditure Guider</h1>
		</div>
        <ul>
            <li><a href="">Tours Calender</a></li>
            <li><a href="InsertBooking">Plan Your Tour</a></li>
            <li><a href="">Tour Guides</a></li>
            
        </ul>
        <div class ="User">
            <%
            	//if user already sign up the system
            	String userName=(String)session.getAttribute("UserName");
            	
            %>
            
            <a href="TravelPlannerAccount.jsp">
            <img src="Images/img2.png" style="cursor: pointer;">
            </a>
            <span><%=userName %></span>
            <a href="Login.jsp">Sign In</a>
            <a href="TravelPlannerInsert.jsp">Sign Up</a>
        </div>
	</nav>
    
</header>
<section class="main-Content">
    <div class="contentWelcome" style="background-image:url('Images/BeachNew.png')">
        <p>Tours are waiting for You...</p>
        
        <form action="SearchServelet" method="post">
        <input type="text" placeholder="Search Your tour.." name="search">
        <button type="submit" class="search"><i class="fa fa-search"></i></button>
        </form>
    </div>
</section>
<section class="descript">
    <div class="mainDes">
    <div class="des1">
        <h1>Expenditure Guider</h1>
        <p>Expenditure Guider has been the leader in the Sri Lanka tourism industry.We guide tours for couples on holiday or honeymoon,for individual nature lovers as well as for special interest and incentives holiday groups.<br><br><b>All foriengs and Sri lankans are welcome</b></p>
        <ul>
            <li><a href="AboutUs.jsp">About Us</a></li>
            <li><a href="">Conatct US</a></li>
        </ul>
    </div>
    <div class="desImg">
        <img src="Images/traveller1.jpg">
    </div>
    <div class="des3">
        <h2><b>WHY JOIN WITH US</b></h2>
        <ul>
            <li>Tailor Made Tours</li>
            <hr>
            <li>Experinced Guides</li>
            <hr>
            <li>Value for Money </li>
            <hr>
            <li>Can Book and Excursion Online</li>
        </ul>
    </div>
</div>
</section>
<section class="tourContainer">
    <div class="topic">
        <h1>Tours</h1>
    </div>
    <div class="tourItem">
        <div class="items item1" style="background: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)),url('Images/Culture.jpg')">
            <a href="TourServlet?category=Culture">
                <h2>Culture Tours</h2>
            </a>
        </div>
        <div class="items item2" style="background: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)),url('Images/wild2.jpg')">
            <a href="TourServlet?category=Wild">
                <h2>WildLife Tours</h2>
            </a>
        </div>
        <div class="items item3" style="background: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)),url('Images/Hill-Country42.jpg')">
            <a href="TourServlet?category=hill-Country">
                <h2>HillCountry Tours</h2>
            </a>
        </div>
        <div class="items item4" style="background: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)),url('Images/Beach-Tours3.jpg')">
            <a href="TourServlet?category=Beach">
                <h2>Beach Tours</h2>
            </a>
        </div>
        <div class="items item5" style="background: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)),url('Images/honeymoonTour.jpg')">
            <a href="TourServlet?category=weddedBliss">
                <h2>Wedded Bliss</h2>
            </a>
        </div>
    </div>
</section>
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
            <li><a href="#top">Home</a></li>
            <li><a href="AboutUs.jsp">About Us</a></li>
            <li><a href="">Tour Calender</a></li>
            <li><a href="">Tour Guides</a></li>
            <li><a href="Feedback.jsp">Reviews</a></li>
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