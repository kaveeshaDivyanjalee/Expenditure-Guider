package Servelets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.TravelPlanner;
import Services.BookingDataAccess;
import Services.ConfirmationMessage;
import Services.TravelPlannerDBUtil;


@WebServlet("/DeletecTravelPlannerServlet")
public class DeletecTravelPlannerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//retriev bookId fro booking retirev page
		String uID=request.getParameter("uid");
		
		System.out.println(uID);
		try {
			boolean isDeleted=TravelPlannerDBUtil.DeleteTravelPlanner(uID);
			
			
			if(isDeleted) {
				System.out.println("Deleted");
				//get confirm meaage
				String confirm=new BookingDataAccess().getMessage("delete");
				
				
				response.sendRedirect("TravelPlannerAccount.jsp");
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Unconfirmed.jsp");
			    dispatcher.forward(request, response);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		String UseriId = request.getParameter("UseriId");
		boolean isTrue;
		
		isTrue = TravelPlannerDBUtil.DeleteTravelPlanner(UseriId);
		
		if (isTrue == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("TravelPlannerInsert.jsp");
			dispatcher.forward(request, response);
		}
		else {
			
			List<TravelPlanner> TrvlPDetails = TravelPlannerDBUtil.getTravelPlannerDetails(UseriId);
			request.setAttribute("TrvlPDetails", TrvlPDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("TravelPlannerInsert.jsp");
			dispatcher.forward(request, response);
		}*/
		
	}

}
