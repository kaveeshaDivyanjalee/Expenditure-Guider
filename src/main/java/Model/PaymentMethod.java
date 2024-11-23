package Model;

public class PaymentMethod {
	
	private String methodID;
	private String method;
	
	public PaymentMethod(String methodID,String method) {
		this.methodID=methodID;
		this.method=method;
	}

	public String getMethodID() {
		return methodID;
	}

	public void setMethodID(String methodID) {
		this.methodID = methodID;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	

}
