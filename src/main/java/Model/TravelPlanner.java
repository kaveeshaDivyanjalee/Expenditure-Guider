package Model;

import java.util.Date;

//TravelPlanner class inherits from the User class
public class TravelPlanner extends User {

	//// Encapsulation: Private fields store the data
	private int userID;
	private String userName;
	private Date createDate;
	
	public TravelPlanner() {}

	// Encapsulation: Public method to get the values
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public TravelPlanner(int userID,String userName,String firstName,String lastName,String email,String password,String mobileNo,String  profilePic,Date createDate2) {
		super(firstName,lastName,email,password,mobileNo,profilePic);
		this.userID=userID;
		this.createDate=createDate2;
		this.userName=userName;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
