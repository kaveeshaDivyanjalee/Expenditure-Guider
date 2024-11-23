package Model;

import java.util.List;

public class Hotel {
	
	private String hotelID;
	private String address;
	private String city;
	private String country;
	private String phoneNo;
	private String weblink;
	private List<String> gallery;
	
	public Hotel(String hotelID,String address,String city,String country,String phoneNo,String weblink,List<String> gallery) {
		this.hotelID=hotelID;
		this.address=address;
		this.city=city;
		this.country=country;
		this.phoneNo=phoneNo;
		this.weblink=weblink;
		this.gallery=gallery;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getWeblink() {
		return weblink;
	}

	public void setWeblink(String weblink) {
		this.weblink = weblink;
	}

	public List<String> getGallery() {
		return gallery;
	}

	public void setGallery(List<String> gallery) {
		this.gallery = gallery;
	}
	
}
