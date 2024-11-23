package Model;

public class Booking {
	
	private String bookingID;
	private String hotelID;
	private int participant;
	private String status;
	private String userID;
	private String tourID;
	private String guideID;
	private String date;
	private double price;
	private String adminID;
	private String vehicleType;
	private String roomNo;
	private String checkOut;
	private String checkIn;
	
	
	public Booking(String bookingID,String hotelID,int participant,String status,String userID,String tourID,String guideID,String date,double price,String adminID,String vehicleType,String roomNo,String checkOut,String checkIn) {
		this.bookingID=bookingID;
		this.hotelID=hotelID;
		this.participant=participant;
		this.status=status;
		this.userID=userID;
		this.tourID=tourID;
		this.guideID=guideID;
		this.date=date;
		this.price=price;
		this.adminID=adminID;
		this.vehicleType=vehicleType;
		this.roomNo=roomNo;
		this.checkIn=checkIn;
		this.checkOut=checkOut;
		
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getBookingID() {
		return bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public int getParticipant() {
		return participant;
	}

	public void setParticipant(int participant) {
		this.participant = participant;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getGuideID() {
		return guideID;
	}

	public void setGuideID(String guideID) {
		this.guideID = guideID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getVehicleNo() {
		return vehicleType;
	}

	public void setVehicleNo(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	
}
