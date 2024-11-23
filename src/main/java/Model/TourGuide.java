package Model;

public class TourGuide extends User {
	
	private String guideID;
	private String mobileNo;
	private String experince;
	private int rate;
	private String language;
	private String Review;
	
	
	public TourGuide(String guideID,String firstName,String lastName,String email,String password,String profilePic,String mobileNo,String experince,int rate,String language,String Review) {
		super(firstName,lastName,email,password,mobileNo,profilePic);
		this.guideID=guideID;
		this.experince=experince;
		this.rate=rate;
		this.language=language;
		this.Review=Review;
	}


	public String getGuideID() {
		return guideID;
	}


	public void setGuideID(String guideID) {
		this.guideID = guideID;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getExperince() {
		return experince;
	}


	public void setExperince(String experince) {
		this.experince = experince;
	}


	public int getRate() {
		return rate;
	}


	public void setRate(int rate) {
		this.rate = rate;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getReview() {
		return Review;
	}


	public void setReview(String review) {
		Review = review;
	}
	

}
