package Servelets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Base64;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Model.LogedUserSession;
import Model.Payment;
import Model.TravelPlanner;
import Services.PaymentDBUtil;
import Services.TravelPlannerDBUtil;


@WebServlet("/UpdateTravelPlannerServlet")
@MultipartConfig
public class UpdateTravelPlannerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public UpdateTravelPlannerServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
    	//call session
		HttpSession session=request.getSession();
		LogedUserSession loggedInUser = (LogedUserSession) session.getAttribute("loggedInUser");
		String uname=loggedInUser.getUserName();
		
		//List<TravelPlanner> planner=TravelPlannerDBUtil.getTravelPlanner(loggedInUser.getUserName());
		List<TravelPlanner> planner=TravelPlannerDBUtil.getTravelPlanner(uname);
		request.setAttribute("planner", planner);
		
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("UpdateTravelPlanner.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	    String UserName = request.getParameter("UserName");
	    String password = request.getParameter("password");
	    String email = request.getParameter("email");
	    String FirstName = request.getParameter("FirstName");
	    String LastName = request.getParameter("LastName");
	      // Retrieves <input type="file" name="ProfilePic">
        
        // Read the image file into byte array
	   /* Part filePart = request.getPart("ProfilePic"); // Retrieve the file part
        byte[] ProfilePic = null;
        if (filePart != null && filePart.getSize() > 0) {  // Check if file is not null or empty
            try (InputStream inputStream = filePart.getInputStream();
                 ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, bytesRead);
                }

                ProfilePic = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "Error uploading profile picture.");
                RequestDispatcher dis = request.getRequestDispatcher("ErrorPage.jsp");
                dis.forward(request, response);
                return; // Exit if there is an error
            	}
        	}*/
	 // Handle Profile Picture upload
        Part filePart = request.getPart("ProfilePic"); // Retrieve the file part
        byte[] ProfilePic = null;
        if (filePart != null && filePart.getSize() > 0) {  // Check if file is not null or empty
            try (InputStream inputStream = filePart.getInputStream();
                 ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, bytesRead);
                }

                ProfilePic = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("rror uploading profile pictur");
                request.setAttribute("errorMessage", "Error uploading profile picture.");
                RequestDispatcher dis = request.getRequestDispatcher("ErrorPage.jsp");
                dis.forward(request, response);
                return; // Exit if there is an error
            	}
        	}


        // Parse Create Date from string
        String createDateStr = request.getParameter("CreateDate");
        Date CreateDate = null;
        if (createDateStr != null && !createDateStr.isEmpty()) {
            try {
                // Use LocalDate for safer date parsing
                LocalDate localDate = LocalDate.parse(createDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
                CreateDate = Date.valueOf(localDate);
            } catch (DateTimeParseException e) {
            	System.out.println("Date Error");
                request.setAttribute("errorMessage", "Invalid date format. Please use yyyy-mm-dd.");
                RequestDispatcher dis = request.getRequestDispatcher("ErrorPage.jsp");
                dis.forward(request, response);
                return; // Exit if there is an error
            }
        } else {
            request.setAttribute("errorMessage", "Create Date cannot be empty.");
            RequestDispatcher dis = request.getRequestDispatcher("ErrorPage.jsp");
            dis.forward(request, response);
            return; // Exit if there is an error
        }
	    
	    boolean isTrue;
		
	    isTrue = TravelPlannerDBUtil.UpdateTravelPlanner(2,UserName,password,email,FirstName,LastName,ProfilePic,CreateDate);
		
		if(isTrue == true) {

			List<TravelPlanner> TrvlPDetails = TravelPlannerDBUtil.getTravelPlannerDetails("2");
			request.setAttribute("TrvlPDetails", TrvlPDetails);

			RequestDispatcher dis = request.getRequestDispatcher("TravelPlannerAccount.jsp");
			dis.forward(request, response);
		}
		
		else {
			List<TravelPlanner> TrvlPDetails = TravelPlannerDBUtil.getTravelPlannerDetails("2");
			request.setAttribute("TrvlPDetails", TrvlPDetails);

			RequestDispatcher dis = request.getRequestDispatcher("TravelPlannerInsert.jsp");
			dis.forward(request, response);
		}
	    
	}

}
