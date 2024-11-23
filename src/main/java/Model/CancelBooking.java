package Model;

public class CancelBooking {
	
	private String cancelID;
	private String reason;
	private String bookID;
	private String status;
	
	public CancelBooking(String cancelID,String reason,String bookID,String status) {
		this.cancelID=cancelID;
		this.reason=reason;
		this.bookID=bookID;
		this.status=status;
	}
	public String getCancelID() {
		return cancelID;
	}
	public void setCancelID(String cancelID) {
		this.cancelID = cancelID;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
