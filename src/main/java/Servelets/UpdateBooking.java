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

import Services.BookingDataAccess;
import Services.BookingInsertServices;
import Services.ConfirmationMessage;
import Services.HotelDataAccess;
import Services.TourDataAccess;

/**
 * Servlet implementation class UpdateBooking
 */
@WebServlet("/UpdateBooking")
public class UpdateBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String bookingId = request.getParameter("bookingId");
		String tourName=request.getParameter("tours");
		System.out.println(tourName);
		
		 if (bookingId != null && !bookingId.trim().isEmpty()) {
		        request.setAttribute("bookingId", bookingId);
		    }
		
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
	        	
		RequestDispatcher dispatcher=request.getRequestDispatcher("UpdatedeBooking.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String bookID=request.getParameter("bookingID");
		String tourName=request.getParameter("tours");
		String tourDate=request.getParameter("tourDate");
		String vType=request.getParameter("vType");
		String member=request.getParameter("member");
		String hotelName=request.getParameter("hotelAcc");
		String RoomType=request.getParameter("roomtype");
		String checkIn=request.getParameter("CheckIn");
		String CheckOut=request.getParameter("CheckOut");
		
		int participant=0;
		
		try {
			participant=Integer.parseInt(member);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			
		}
		
		boolean isInserted = false;
		//UpdateUserReservation(String bookID,String tourName,String tourDate,String vType,int member,String hotelName,
		//String RoomType,String checkIn,String CheckOut) 
		try {
			isInserted=BookingDataAccess.UpdateUserReservation(bookID, tourName, tourDate, vType, participant, hotelName, RoomType, checkIn, CheckOut);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(isInserted) {
			System.out.println("update SuccessFull");
			//get confirm meaage
			String confirm=new BookingDataAccess().getMessage("update");
			//create object for confirmationMessage
			HttpSession session=request.getSession();
			ConfirmationMessage cMessage=new ConfirmationMessage();
			String message=cMessage.getMessage("delete");
			
			session.setAttribute("message", message);
			//after delete redirect the booiking view
			response.sendRedirect("BookingView.jsp");
		}
		else {
			System.out.println("update unSuccessFull");
			RequestDispatcher dispatcher=request.getRequestDispatcher("Unconfirmed.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	}

}
