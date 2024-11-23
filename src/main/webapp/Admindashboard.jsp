<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="CSS/homeCSS.css">
    <link rel="stylesheet" type="text/css" href="CSS/Admindashboard.css">
    <style>
        /* Ensure the images are aligned in a row */
        .image-row {
            display: flex;
            justify-content: space-between;
        }

        /* Style for individual image containers */
        .image-container {
            position: relative;
            width: 30%;
        }

        /* Ensure images are responsive */
        .image-container img {
            width: 100%;
            height: auto;
        }
        
        /* Position the caption text over the image */
        .caption {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            color: white;
            text-align: center;
            z-index: 2;
            font-size: 24px;
            text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.7); /* Text shadow for better readability */
        }
    </style>
</head>
<body>
    <header style="margin-bottom: 150px;">
        <nav>
            <div class="logo">
                <h1>Expenditure Guider</h1>
            </div>
            <ul class="nav-links">
                <!-- Menu 1 -->
                <li><a href="">Tourism Location</a>
                    <ul class="dropdown">
                        <li><a href="#">Add Tourism Location</a></li>
                        <li><a href="#">View Tourism Location</a></li>
                        
                    </ul>
                </li>
                <!-- Menu 2 -->
                <li><a href="">Package</a>
                    <ul class="dropdown">
                        <li><a href="">Add Package</a></li>
                        <li><a href="">View Package</a></li>
                        
                    </ul>
                </li>
                <!-- Menu 3 -->
                <li><a href="">Hotel</a>
                    <ul class="dropdown">
                        <li><a href="">Add Hotel</a></li>
                        <li><a href="">View Hotel</a></li>
                        
                    </ul>
                </li>
                <!-- Menu 4 -->
                <li><a href="">Users</a>
                    <ul class="dropdown">
                        <li><a href="">Add Tour Guide</a></li>
                        <li><a href="">View Tour Guides</a></li>
                        
                    </ul>
                </li>
            </ul>
            <div class="User">
                <img src="Images/img2.png">
                <a href="">Sign In</a>
            </div>
        </nav>
    </header>

    <!-- Call to Action Section Start-->
    <section class="mg_travelplan">
        <div class="container">
            <!-- iqoniq Heading Start -->
            <div class="mg_hotel_hd1 white" style="text-align: center;">
                <h1><b>DASHBOARD</b></h1>
            </div>
            <!-- iqoniq Heading End -->
        </div>
    </section>
    <!-- Call to Action Section End-->

    <!-- iqoniq Content Wrapper Start-->
    <div class="iqoniq_content_wrapper">
        <!-- Image Row Section Start-->
        <section class="image_row_wrap">
            <div class="container">
                <div class="row">
				<div class="col-md-4 col-sm-6">
					<a href="">
						<div class="mg_pricing fancy-overlay">
							<div class="thumb">
								<img src="Images/TourPlanner.jpeg" alt="Tour Planner">
								<div class="caption">
									<h2>TOUR PLANNER</h2>
									<b>records</b>
								</div>
							</div>
						</div>
					</a>
				</div>

				<div class="col-md-4 col-sm-6">
					<a href="viewfeedback.php">
						<div class="mg_pricing fancy-overlay">
							<div class="thumb">
								<img src="Images/Feedback.jpeg" alt="Feedback">
								<div class="caption">
									<h2>FEEDBACK</h2>
									<b>records</b>
								</div>
							</div>
						</div>
					</a>
				</div>

				<div class="col-md-4 col-sm-6">
					<a href="viewgallery.php">
						<div class="mg_pricing fancy-overlay">
							<div class="thumb">
								<img src="Images/Booking.jpeg" alt="Booking">
								<div class="caption">
									<h2>BOOKING</h2>
									<b>records</b>
								</div>
							</div>
						</div>
					</a>
				</div>
			</div>

			<!-- Next row -->
			<div class="row">
				<div class="col-md-4 col-sm-6">
					<a href="viewhotel.php">
						<div class="mg_pricing fancy-overlay">
							<div class="thumb">
								<img src="Images/Hotel.jpeg" alt="Hotel">
								<div class="caption">
									<h2>HOTEL</h2>
									<b>records</b>
								</div>
							</div>
						</div>
					</a>
				</div>

				<div class="col-md-4 col-sm-6">
					<a href="">
						<div class="mg_pricing fancy-overlay">
							<div class="thumb">
								<img src="Images/Tour.jpeg" alt="Tour">
								<div class="caption">
									<h2>TOUR</h2>
									<b>records</b>
								</div>
							</div>
						</div>
					</a>
				</div>

				<div class="col-md-4 col-sm-6">
					<a href="">
						<div class="mg_pricing fancy-overlay">
							<div class="thumb">
								<img src="Images/Location.jpeg" alt="Location">
								<div class="caption">
									<h2>LOCATION</h2>
									<b>records</b>
								</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-md-4 col-sm-6">
					<a href="">
						<div class="mg_pricing fancy-overlay">
							<div class="thumb">
								<img src="Images/Payment.jpeg" alt="Payment">
								<div class="caption">
									<h2>Payment</h2>
									<b>records</b>
								</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-md-4 col-sm-6">
					<a href="">
						<div class="mg_pricing fancy-overlay">
							<div class="thumb">
								<img src="TourPackages.jpeg" alt="Package">
								<div class="caption">
									<h2>Package</h2>
									<b>records</b>
								</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-md-4 col-sm-6">
					<a href="">
						<div class="mg_pricing fancy-overlay">
							<div class="thumb">
								<img src="Vehicle.jpeg" alt="Vehicle">
								<div class="caption">
									<h2>Vehicle</h2>
									<b>records</b>
								</div>
							</div>
						</div>
					</a>
				</div>
				
                    
                </div>
            </div>
        </section>
        <!-- Image Row Section End-->
    </div>
    <!-- iqoniq Content Wrapper End-->

    <footer class="navbar navbar-default" style="margin-top: 70px; padding-top: 20px; padding-bottom: 20px;">
        <nav>
            <div class="paymentMethod">
                <div>
                    <img src="Images/visa.png">
                </div>
                <div>
                    <img src="Images/master.png">
                </div>
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
                <a href="">Privacy & policy </a>
                <span></span>
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

