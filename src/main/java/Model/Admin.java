package Model;

public class Admin extends User{
	
	private String adminID;
	private String managerId;
	
	public Admin() {
		super();
	}
	
	public Admin(String adminID,String firstName,String lastName,String email,String password, String profilePic,String managerId,String mobileNo) {
		super(firstName,lastName,email,password,mobileNo,profilePic);
		this.adminID=adminID;
		this.managerId=managerId;
		
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
}
