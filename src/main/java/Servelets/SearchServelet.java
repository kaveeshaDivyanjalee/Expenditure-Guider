package Servelets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import Model.Tour;
import Services.CatergoryDataAccess;
import Services.TourDataAccess;

/**
 * Servlet implementation class SearchServelet
 */
@WebServlet("/SearchServelet")
public class SearchServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Tour tourModel=new Tour();
		
		String catName=request.getParameter("search");
		
		if(catName==null || catName.trim().isEmpty()) {
			request.setAttribute("err", "please enter catergory to search");
			RequestDispatcher dispatcher=request.getRequestDispatcher("HomePage.jsp");
			dispatcher.forward(request, response);
			return;
		}
		try {
			
			List<Tour> selectedTour=TourDataAccess.getTourDetailsBycatergory(CatergoryDataAccess.generateIDbyName(catName));
			
			//set tours to accessible in the jsp page
			request.setAttribute("selectedTour", selectedTour);
			
			
			//pass selected data to redirect page
			RequestDispatcher  dispacher=request.getRequestDispatcher("SearchTour.jsp");
			dispacher.forward(request, response);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
