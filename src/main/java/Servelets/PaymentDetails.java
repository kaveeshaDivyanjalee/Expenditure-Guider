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

import Model.Payment;
import Services.PaymentDBUtil;

/**
 * Servlet implementation class PaymentDetails
 */
@WebServlet("/PaymentDetails")
public class PaymentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		HttpSession session=request.getSession();
		int uid=(int) session.getAttribute("userID");
		
		if(uid == 0) {
			response.sendRedirect("Login.jsp");
		}
		
		List<Payment> paymentDetails=PaymentDBUtil.getPaymentDetails(1);
		request.setAttribute("paymentDetails",paymentDetails);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("PaymentDetails.jsp");
		dispatcher.forward(request, response);
		
		doGet(request, response);
	}

}