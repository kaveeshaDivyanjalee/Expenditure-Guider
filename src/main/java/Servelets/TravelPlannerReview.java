package Servelets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.LogedUserSession;
import Model.TravelPlanner;
import Services.TravelPlannerDBUtil;

/**
 * Servlet implementation class TravelPlannerReview
 */
@WebServlet("/TravelPlannerReview")
public class TravelPlannerReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelPlannerReview() {
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
		
		//call session
		HttpSession session=request.getSession();
		LogedUserSession loggedInUser = (LogedUserSession) session.getAttribute("loggedInUser");
		doGet(request, response);
		//List<TravelPlanner> planner=TravelPlannerDBUtil.getTravelPlanner(loggedInUser.getUserName());
		String uname=loggedInUser.getUserName();
		List<TravelPlanner> planner=TravelPlannerDBUtil.getTravelPlanner(uname);
		request.setAttribute("planner", planner);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("TravelPlannerAccount.jsp");
		dispatcher.forward(request, response);
	}

}
