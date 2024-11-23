/**
 * 
 */
package Services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Controller.DBConection;
import Model.BookingRetriev;
import Model.Tour;

/**
 * 
 */
public class BookingDataAccess extends ConfirmationMessage{
	
	//create static varaible for db connection
	private static Connection con=null;
	private static PreparedStatement  statement=null;
	private static ResultSet rs=null;

	//Insert user Booking	
	public static boolean insertBooking(String tourName,String tourDate,String mobile,String email,String hotel,String roomType,String guideChoice,String vehiclechoice,String vtype,String checkIn,String CheckOut,int member) {
		
		boolean isSuccess=false;
		
		
		
		try {
			con=DBConection.getConnection();
			
			
			//insert query
			String sql="INSERT INTO booking (bookingID, Participant, TotalPrice, UserID, tourID, GuideID, bookingDate, AdminID, VehicleType, hotelID, RoomNo, CheckInDate, CheckOutDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			statement=con.prepareStatement(sql);
			
			String bookID=BookingInsertServices.generateBookID();
			int uid=TravelPlannerDataAccessService.retrievUserID(mobile, email);
			int tourid=0;
			String guidID=null;
			String adminID=AdminDataAccessServices.assignAdminId();
			String hotelID=HotelDataAccess.retrievHotelID(hotel);
			String type=null;
			String roomNo=BookingInsertServices.assignRoomNo(roomType,hotelID);
			
			//get cuurent date
			LocalDate currentDate=LocalDate.now();
			
			//get Tour details as a list
			List<Tour> details=TourDataAccess.tourDetails(tourName);
			double totprice=0;
			
			if(!details.isEmpty()) {
				totprice=details.get(0).getCost()*member;
				tourid=details.get(0).getTourID();
			}
			
			//guid id
			if(guideChoice.equals("yes")) {
				guidID=BookingInsertServices.assignTourGuide(CheckOut,tourDate);
				
			}
			if(vehiclechoice.equals("yes")) {
				type=vtype;
			}
			
			
			//assign value
			statement.setString(1,bookID);
			statement.setInt(2, member);
			statement.setDouble(3, totprice);
			statement.setInt(4, uid);
			statement.setInt(5, tourid);
			statement.setString(6, guidID);	
			statement.setDate(7,Date.valueOf(currentDate));
			statement.setString(8, adminID);
			statement.setString(9, type);
			statement.setString(10, hotelID);
			statement.setString(11, roomNo);
			statement.setDate(12,Date.valueOf(checkIn));
			statement.setDate(13,Date.valueOf(CheckOut));
			
			int rs=statement.executeUpdate();
			
			if (guidID != null) {
		        // Handle the case when no guide is available
		        System.out.println("tour guide is available for the selected date range.");
		        BookingInsertServices.AssignTourSchedule(bookID,tourDate,CheckOut,guidID);
		      //String b_id,String s_date,String e_date,String guide
			}
			if(rs>0) {
				isSuccess=true; 
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		
		}
		return isSuccess;
	}
	
	
	//retiew user data
	public static List<BookingRetriev> retriewBookingRecord(String startDate,String endDate,int userID) throws SQLException {
		
		//call List type refrence in ArrayList object
		List<BookingRetriev> detail=new ArrayList<>();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
		
		try {
			
			con=DBConection.getConnection();
			String sql="Select * from booking where UserID=? and bookingDate between ? and ? ";
			
			statement=con.prepareStatement(sql);
			
			statement.setInt(1, userID);
			statement.setString(2, startDate);
			statement.setString(3, endDate);
			
			rs=statement.executeQuery();
			
			while(rs.next()) {
				
				String id=rs.getString(1);
				int member=rs.getInt(2);
				double total=rs.getDouble(3);
				String status=rs.getString(4);
				int uID=rs.getInt(5);
				int tourID=rs.getInt(6);
				String guideID=rs.getString(7);
				Date bookingdate=rs.getDate(8);
				String admin=rs.getString(9);
				String type=rs.getString(10);
				String hotelID=rs.getString(11);
				String RoomNo=rs.getString(12);
				Date checkIn=rs.getDate(13);
				Date checkOut=rs.getDate(14);
				
				String tourName=TourDataAccess.getTourNameByTourID(tourID);
				
				//covert data to String
				String bookDate = formatter.format(bookingdate);
				String dateIn = formatter.format(checkIn);
				String dateOut = formatter.format(checkOut);
				
				String hotelName=HotelDataAccess.hotelNameusingId(hotelID);
				String roomType=BookingInsertServices.retrievRoomType(RoomNo);
				String guideName=GuideDataAccess.retriewGuideName(guideID);
				
				//assign value to booing Retriew class using overload constructor
				BookingRetriev b=new BookingRetriev(id,tourName,member,bookDate,hotelName,RoomNo,roomType,guideName,total,type,dateOut,dateIn,status);
				
				detail.add(b);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//close the conncetion
			rs.close();
            statement.close();
            con.close();
		}
		return detail;
	}
	
		//Update User Reservation
	public static boolean UpdateUserReservation(String bookID,String tourName,String tourDate,String vType,int member,String hotelName,String RoomType,String checkIn,String CheckOut) throws SQLException {
			
		boolean isSuccess=false;
		
		try {
			con=DBConection.getConnection();
			
			
			//insert query
			String sql="Update booking Set Participant=?, TotalPrice=?, tourID=?, GuideID=?, VehicleType=?, hotelID=?, RoomNo=?, CheckInDate=?, CheckOutDate=? Where bookingID=?";
			
			statement=con.prepareStatement(sql);
			
			int tourid=0;
			String guidID=null;
			String hotelID=HotelDataAccess.retrievHotelID(hotelName);
			//get room number releted to user entered hotel and room type
			String roomNo=BookingInsertServices.assignRoomNo(RoomType,hotelID);
			
			
			//get Tour details as a list
			List<Tour> details=TourDataAccess.tourDetails(tourName);
			double totprice=0;
			
			if(!details.isEmpty()) {
				totprice=details.get(0).getCost()*member;
				tourid=details.get(0).getTourID();
			}
			//Automatically system check and add admin to the tours
			String admin=AdminDataAccessServices.retriewAdmiiniID(bookID);
			//Automatically system check and add tour guide to the tours
			guidID=BookingInsertServices.assignTourGuide(CheckOut,tourDate);
			
			//assign value
			
			statement.setInt(1, member);
			statement.setDouble(2, totprice);
			statement.setInt(3, tourid);
			statement.setString(4, guidID);	
			statement.setString(5, vType);
			statement.setString(6, hotelID);
			statement.setString(7, roomNo);
			statement.setDate(8,Date.valueOf(checkIn));
			statement.setDate(9,Date.valueOf(CheckOut));
			statement.setString(10,bookID);
			
			int rs=statement.executeUpdate();
			
			if (guidID != null) {
		        // Handle the case when no guide is available
		        System.out.println("tour guide is available for the selected date range.");
		        BookingInsertServices.updateTourGuideSchedule(checkIn, CheckOut, guidID, bookID);
			}
			//console checking
			System.out.println("Executing update with bookingID: " + bookID);
			if(rs>0) {
				isSuccess=true; 
				System.out.println(new BookingDataAccess().getMessage("update"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//close connectivity
			rs.close();
            statement.close();
            con.close();
		}
		return isSuccess;
	}
		
	public static boolean DeleteReservertion(String book_ID) throws ClassNotFoundException, SQLException {
		//initialize boolean type variable	
		boolean isDeleted=false;
		
		try {
			con=DBConection.getConnection();
			
			//get deleted record roomNo
			String roomNo=BookingInsertServices.retriewRoomNobyBookingID(book_ID);
			//delete record from database
			String sql="Delete From booking Where bookingID=?";
			statement=con.prepareStatement(sql);
			//fetch value to where condition
			statement.setString(1,book_ID);
			int rs=statement.executeUpdate();
			
			//delete record from guide_Schedule and set availability of roomNo
			//if the booking tour is delete change room availability
			BookingInsertServices.setRoomAvailability(roomNo, 1);
			
			if(rs>0) {
				isDeleted=true;
				//call the super
				System.out.println(new BookingDataAccess().getMessage("delete"));
				//delete schedule id
				BookingInsertServices.deleteSchedule(book_ID);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return isDeleted;
	}
			
		
}
