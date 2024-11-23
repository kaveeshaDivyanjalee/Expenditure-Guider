package Model;

import java.util.List;

public class Tour {
	
	private int tourID;
	private String title;
	private String description;
	private double cost;
	private String duration;
	private String categoryID;
	private String adminID;
	private String coverImage;
	private String city;
	private String nearCity;
	private List<String> imageGallery;
	
	public Tour() {
		this.tourID=0;
		this.title=null;
		this.description=null;
		this.cost=0;
		this.duration=null;
		this.categoryID=null;
		this.adminID=null;
		this.coverImage=null;
		this.city=null;
		this.nearCity=null;
		this.imageGallery=null;
	}
	
	public Tour(int tourID,String title,String description,double cost,String duration,String categoryID,String adminID,String coverImage,String city,String nearCity,List<String> imageGallery) {
		
		this.tourID=tourID;
		this.title=title;
		this.description=description;
		this.cost=cost;
		this.duration=duration;
		this.categoryID=categoryID;
		this.adminID=adminID;
		this.coverImage=coverImage;
		this.city=city;
		this.nearCity=nearCity;
		this.imageGallery=imageGallery;
		
	}
	public int getTourID() {
		return tourID;
	}
	public void setTourID(int tourID) {
		this.tourID = tourID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getCatergeryID() {
		return categoryID;
	}
	public void setCatergeryID(String catergeryID) {
		this.categoryID = catergeryID;
	}
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	public List<String> getImageGallery() {
		return imageGallery;
	}
	public void setImageGallery(List<String> imageGallery) {
		this.imageGallery = imageGallery;
	}
	public String getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNearCity() {
		return nearCity;
	}
	public void setNearCity(String nearCity) {
		this.nearCity = nearCity;
	}
	public String toString() {
		return tourID+""+title+""+description+""+categoryID+"";
	}
	
		 
			
	
	
}
