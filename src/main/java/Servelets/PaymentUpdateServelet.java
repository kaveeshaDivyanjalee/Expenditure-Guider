package Servelets;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.HotelDataAccess;
import Services.PaymentDBUtil;
import Services.TourDataAccess;
import Model.Payment;

@WebServlet("/PaymentUpdateServlet")
public class PaymentUpdateServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PaymentUpdateServelet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String pID = request.getParameter("paymentID");
		System.out.println(pID);
		
		try {
			Payment pay=PaymentDBUtil.retriewPaymentDetailsUsingID(pID);
			request.setAttribute("pay", pay);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("PaymentUpdate.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve form parameters (excluding Status and Book ID)
		String payID = request.getParameter("payIDtext");
		String dateStr = request.getParameter("date");
		BigDecimal amount = new BigDecimal(request.getParameter("amount"));
		String paymentMethod = request.getParameter("paymentMethod");
		String transactionID = request.getParameter("transactionID");
		String packageType = request.getParameter("packageType");
		
		// Update payment details in the database
		boolean isTrue = PaymentDBUtil.updatePayment(payID, dateStr, amount, paymentMethod, transactionID, packageType);
		
		if(isTrue) {
			// Retrieve updated payment details
			List<Payment> paymentDetails = PaymentDBUtil.getPaymentDetails(1);
			request.setAttribute("paymentDetails", paymentDetails);
			
			// Forward to PaymentDetails.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("PaymentDetails.jsp");
			dispatcher.forward(request, response);
		} else {
			// Retrieval even if update failed (optional)
			List<Payment> paymentDetails = PaymentDBUtil.getPaymentDetails(1);
			request.setAttribute("paymentDetails", paymentDetails);
			
			// Forward to unsuccess.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("unsuccess.jsp");
			dispatcher.forward(request, response);
		}
	}
}
