package Model;

public class Feedback {
	
	private int feedbackID;
	private int rate;
	private String comment;
	private String date;
	private String userID;
	private String tourID;
	private String adminID;
	
	public Feedback(int feedbackID,int rate,String comment,String date,String userID,String tourID,String adminID) {
		this.feedbackID=feedbackID;
		this.rate=rate;
		this.comment=comment;
		this.date=date;
		this.userID=userID;
		this.tourID=tourID;
		this.adminID=adminID;
	}

	public int getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getTourID() {
		return tourID;
	}

	public void setTourID(String tourID) {
		this.tourID = tourID;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	
	

}
