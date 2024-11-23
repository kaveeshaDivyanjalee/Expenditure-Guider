package Servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.DBConection;
import Model.LogedUserSession;
import Model.TravelPlanner;
import Services.AdminDataAccessServices;
import Services.GuideDataAccess;
import Services.TravelPlannerDBUtil;
import Services.UserBaseOperations;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String UserName = request.getParameter("UserName");
		String password = request.getParameter("password");
		
		
		UserBaseOperations palnner=new TravelPlannerDBUtil();
		if (palnner.Validate(UserName, password)){
			 	List<TravelPlanner> TrvlPDetails = TravelPlannerDBUtil.getTravelPlanner(UserName);
			 	//System.out.println(TrvlPDetails.get(0));
			 	//Create session for if user is tourguide
			 	 if (!TrvlPDetails.isEmpty()) {
			 		 	int userID = TrvlPDetails.get(0).getUserID();
			 		 	
			 		 	//create and store user details in a session
			 		 	HttpSession session = request.getSession();
		                session.setAttribute("UserName", UserName);
		                session.setAttribute("userID", userID);
			 		 	LogedUserSession loggedInUser = new LogedUserSession(UserName, userID);
			 		 	session.setAttribute("loggedInUser", loggedInUser);
		                
		                //if login success redirect the homepage
		                response.sendRedirect("HomePage.jsp");
		                return;
		                
		            } else {
		                // If no user details were found, redirect to login page with an error message
		                out.println("<script type='text/javascript'>");
		                out.println("alert('No user details found for the provided username.');");
		                out.println("location='Login.jsp';");
		                out.println("</script>");
		                return;
		            }

		    }
			
		 //
		 UserBaseOperations adminLogin=new AdminDataAccessServices();
		 if (adminLogin.Validate(UserName, password)){
			 	String AdminDetails = AdminDataAccessServices.retrievAdminiDetails(UserName);
				HttpSession session = request.getSession();
	            session.setAttribute("UserName", AdminDetails);
	            response.sendRedirect("Admindashboard.jsp");
	            return;

	        } 
		 UserBaseOperations guidLogin=new GuideDataAccess();  
		 if (guidLogin.Validate(UserName, password)){
			 	String TourGuideDetails = GuideDataAccess.retriewGuideName(UserName);
			 	request.setAttribute("TourGuideDetails", TourGuideDetails);
				HttpSession session = request.getSession();
	            session.setAttribute("UserName", UserName);
	            response.sendRedirect("Index.html");
	            return;

	        } 

		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location='Login.jsp'");
			out.println("</script>");
		}
		
	}

}
	


