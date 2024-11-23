package Model;

public class Location {
	
	private String locatID;
	private String name;
	private String district;
	private String country;
	
	public Location(String locatID,String name,String district,String country) {
		this.locatID=locatID;
		this.name=name;
		this.district=district;
		this.country=country;
	}

	public String getLocatID() {
		return locatID;
	}

	public void setLocatID(String locatID) {
		this.locatID = locatID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	

}
