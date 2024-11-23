package Model;

public class Package {
	
	private String packageID;
	private String name;
	private double discount;
	private String adminID;
	
	public Package(String packageID,String name,double discount,String adminID) {
		this.packageID=packageID;
		this.name=name;
		this.discount=discount;
		this.adminID=adminID;
	}

	public String getPackageID() {
		return packageID;
	}

	public void setPackageID(String packageID) {
		this.packageID = packageID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	
}
