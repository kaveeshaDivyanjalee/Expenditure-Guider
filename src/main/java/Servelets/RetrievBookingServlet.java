package Servelets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BookingRetriev;
import Services.BookingDataAccess;

/**
 * Servlet implementation class RetrievBookingServlet
 */
@WebServlet("/RetrievBookingServlet")
public class RetrievBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrievBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//session create for gent logged user details
		
		HttpSession session=request.getSession();
		int userId=(int)session.getAttribute("userID");
		
		if(userId == 0) {
			response.sendRedirect("Login.jsp");
		}
		
		//get start date and end date user search
		String sdate=request.getParameter("start");
		String edate=request.getParameter("End");
		
		List<BookingRetriev> booking = null;
		try {
			booking = BookingDataAccess.retriewBookingRecord(sdate, edate, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("booking", booking);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookingView.jsp");
	    dispatcher.forward(request, response);
	}

}
