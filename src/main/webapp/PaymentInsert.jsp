<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Payment</title>    
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">    
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">    
   
    <link rel="stylesheet" type="text/css" href="CSS/homeCSS.css">    
    
    <style>
        body {
            background-color: #e0f7fa; 
            margin: 0;
            padding: 0;
        }
        
        .container {
            margin-top: 50px;
            max-width: 600px;
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        }
        
        .form-label {
            font-weight: bold;
        }
        
        .btn-submit {
            width: 100%;
            padding: 10px;
            font-size: 18px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
        }
        
        .btn-submit:hover {
            background-color: #0056b3;
        }
        
        h2 {
            margin-bottom: 20px;
            text-align: center;
        }
        
        .readonly-input {
            background-color: #e9ecef;
            cursor: not-allowed;
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
                <li><a href="">Tours Calendar</a></li>
                <li><a href="">Plan Your Tour</a></li>
                <li><a href="">Tour Guides</a></li>
            </ul>
            <div class="User">
                <img src="Images/img2.png" alt="User Icon">
                <a href="">Sign In</a>
            </div>
        </nav>
    </header>

    <div class="container">
        <h2>ADD PAYMENT</h2>

        <form action="PaymentInsert" method="post">         

           
            <div class="mb-3">
                <label for="date" class="form-label">Date:</label>
                <input type="date" class="form-control readonly-input" name="date" value="${dateStr}" >
            </div>
            
            <div class="mb-3">
                <label for="amount" class="form-label">Amount:</label>
                <input type="number" class="form-control" name="amount" step="0.01" min="0" required>
            </div>
            
            <div class="mb-3">
                <label for="paymentMethod" class="form-label">Payment Method:</label>
                <select class="form-control" name="paymentMethod" required>
                    <option value="" disabled selected>Select Payment Method</option>
                    <option value="Bank Transfer">Bank Transfer</option>
                    <option value="Credit Card">Credit Card</option>
                    <option value="Debit Card">Debit Card</option>
                </select>
            </div>
           
            <div class="mb-3">
                <label for="packageType" class="form-label">Package:</label>
                <select class="form-control" name="packageType" required>
                    <option value="" disabled selected>Select Package</option>
                    <option value="Family">Family</option>
                    <option value="Group">Group</option>
                    <option value="Loyalty">Loyalty</option>
                </select>
            </div>

            <button type="submit" class="btn-submit">ADD PAYMENT</button>
        </form>
    </div>

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
