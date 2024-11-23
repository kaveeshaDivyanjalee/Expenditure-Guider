package Model;

public class Complain {
	
	private String complainID;
	private String complain;
	private String userID;
	private String adminID;
	
	public Complain(String complainID,String complain,String userID,String adminID) {
		this.complainID=complainID;
		this.complain=complain;
		this.userID=userID;
		this.adminID=adminID;
	}

	public String getComplainID() {
		return complainID;
	}

	public void setComplainID(String complainID) {
		this.complainID = complainID;
	}

	public String getComplain() {
		return complain;
	}

	public void setComplain(String complain) {
		this.complain = complain;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	
}
