package Model;

public class BookingRetriev {
	
	
	private String bookingID;
	private String tourName;
	private int participant;
	private String bookDate;
	private String hotelName;
	private String roomNo;
	private String roomType;
	private String guideName;
	private double price;
	private String vehicleType;
	private String checkOut;
	private String checkIn;
	private String status;
	
	public BookingRetriev(String bookingID, String tourName, int participant, String bookDate, String hotelName,
			String roomNo, String roomType, String guideName, double price, String vehicleType, String checkOut, String checkIn,String status) {
		
		this.bookingID = bookingID;
		this.tourName = tourName;
		this.participant = participant;
		this.bookDate = bookDate;
		this.hotelName = hotelName;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.guideName = guideName;
		this.price = price;
		this.vehicleType = vehicleType;
		this.checkOut = checkOut;
		this.checkIn = checkIn;
		this.status = status;
	}

	public String getBookingID() {
		return bookingID;
	}

	public String getTourName() {
		return tourName;
	}

	public int getParticipant() {
		return participant;
	}

	public String getBookDate() {
		return bookDate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public String getGuideName() {
		return guideName;
	}

	public double getPrice() {
		return price;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public String getStatus() {
		return status;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public void setParticipant(int participant) {
		this.participant = participant;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	
	
}
