package Servelets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Services.BookingDataAccess;
import Services.BookingInsertServices;
import Services.ConfirmationMessage;
import Services.HotelDataAccess;
import Services.OperationValidation;
import Services.TourDataAccess;

/**
 * Servlet implementation class InsertBooking
 */
@WebServlet("/InsertBooking")
public class InsertBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String tourName=request.getParameter("tours");
		System.out.println(tourName);
		
		if (tourName != null && !tourName.trim().isEmpty()) {
	            ArrayList<String> hotel = HotelDataAccess.hotelNameGenerator(tourName);
	           // request.setAttribute("hotel", hotel);
	            request.setAttribute("hotel", hotel);
	     }
		ArrayList<String> tourTitle=TourDataAccess.tourNameGenerator();
		if (tourTitle.isEmpty()) {
		    System.out.println("No tours available");
		} else {
		    System.out.println("Tours loaded: " + tourTitle);
		}
		request.setAttribute("tourTitle", tourTitle);
		System.out.println(tourTitle);
	        	
		RequestDispatcher dispatcher=request.getRequestDispatcher("BookingUI.jsp");
		dispatcher.forward(request, response);
	        
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//String tourName,String tourDate,String mobile,String email,String hotel,String roomType,String guideChoice,
		//String vehiclechoice,String vtype,String checkIn,String CheckOut,int member
		String tourName=request.getParameter("tours");
		String tourDate=request.getParameter("tourDate");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("mail");
		String hotel=request.getParameter("hotelAcc");
		String roomType=request.getParameter("roomtype");
		String guideChoice=request.getParameter("choice");
		String vehiclechoice=request.getParameter("vehicle");
		String vtype=request.getParameter("vType");
		String checkIn=request.getParameter("CheckIn");
		String CheckOut=request.getParameter("CheckOut");
		String member=request.getParameter("member");
		int participant=0;
		
		
		
		boolean isInserted=false;
		
		isInserted=BookingDataAccess.insertBooking(tourName, tourDate, mobile, email, hotel, roomType, guideChoice, vehiclechoice, vtype, checkIn, CheckOut, participant);
		
		if(isInserted) {
			System.out.println("Inserting SuccessFull");
			String id=BookingInsertServices.lastBookIDRelease();
			request.setAttribute("id", id);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("confirm.jsp");
			dispatcher.forward(request, response);
		}
		else {
			System.out.println("Inserting unSuccessFull");
			RequestDispatcher dispatcher=request.getRequestDispatcher("Unconfirmed.Jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	}

}
