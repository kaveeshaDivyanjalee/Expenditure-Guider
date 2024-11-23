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

import Model.Payment;
import Services.PaymentDBUtil;

@WebServlet("/PaymentDeleteServlet")
public class PaymentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PaymentDeleteServlet() {
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
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("PaymentDelete.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve PayID from the form
		String id = request.getParameter("payID");
		boolean isTrue;
		
		// Delete payment from the database
		isTrue = PaymentDBUtil.deletePayment(id);
		
		if(isTrue) {
			System.out.println("Deleted");
			// Forward to InsertPayment.jsp after successful deletion
			RequestDispatcher dispatcher = request.getRequestDispatcher("PaymentDetails.jsp");
			dispatcher.forward(request, response);
		} else {
			// Optionally retrieve payment details if deletion failed
			List<Payment> paymentDetails = PaymentDBUtil.getPaymentDetails(1);
			request.setAttribute("paymentDetails", paymentDetails);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("PaymentInsert.jsp");
			dispatcher.forward(request, response);
		}
	}
}
