package Servelets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.BookingDataAccess;
import Services.ConfirmationMessage;

/**
 * Servlet implementation class DeleteBookingServlet
 */
@WebServlet("/DeleteBookingServlet")
public class DeleteBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//retriev bookId fro booking retirev page
		String bookID=request.getParameter("bookingID");
		
		try {
			boolean isDeleted=BookingDataAccess.DeleteReservertion(bookID);
			
			
			if(isDeleted) {
				System.out.println("Deleted");
				//get confirm meaage
				String confirm=new BookingDataAccess().getMessage("delete");
				
				//create object for confirmationMessage
				HttpSession session=request.getSession();
				ConfirmationMessage cMessage=new ConfirmationMessage();
				String message=cMessage.getMessage("delete");
				
				session.setAttribute("message", message);
				//after delete redirect the booiking view
				response.sendRedirect("BookingView.jsp");
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Unconfirmed.jsp");
			    dispatcher.forward(request, response);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
