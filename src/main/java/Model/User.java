package Model;

public class User {
		
	//declare propertise for all users
	
	protected  String firstName;
	protected  String lastName;
	protected String email;
	protected String password;
	protected String mobileNo;
	protected String profilePic;
	
	public User() {}
	public User(String firstName,String lastName,String email,String password,String mobileNo, String profilePic) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.password=password;
		this.profilePic=profilePic;
		this.mobileNo=mobileNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	
	
}
