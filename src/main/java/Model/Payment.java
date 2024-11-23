package Model;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {
    private String payID;
    private String date;
    private BigDecimal amount;
    private String paymentMethod;
    private String status;
    private String transactionID;
    private String packageID;
    
    // Default Constructor
    public Payment() {}

    // Parameterized Constructor
    public Payment(String payID, String date, BigDecimal amount, String paymentMethod,String status,
                  String transactionID, String packageID) {
        this.payID = payID;
        this.date = date;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status=status;
        this.transactionID = transactionID;
        this.packageID = packageID;
        
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayID() {
		return payID;
	}

	public void setPayID(String payID) {
		this.payID = payID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getPackageID() {
		return packageID;
	}

	public void setPackageID(String packageID) {
		this.packageID = packageID;
	}

	
    
}

