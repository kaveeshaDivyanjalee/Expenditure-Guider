package Services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Controller.DBConection;
import Model.Tour;

public class BookingInsertServices {

	private static Connection con=null;
	private static PreparedStatement  statement=null;
	private static ResultSet rs=null;
	

	//date format
	public static Date convertToDate(String dateString) throws ParseException {
	    
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    format.setLenient(false);
	    
	    java.util.Date utilDate = format.parse(dateString);
	    
	    return new Date(utilDate.getTime());
	}
	
	
	
	
	//auto generate booking ID
	
	public static String generateBookID() throws SQLException {
			
			try {
				con=DBConection.getConnection();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//get last Id of the booking table
			String sql="Select MAX(bookingID) AS maxBookingID From booking";
			statement=con.prepareStatement(sql);
			rs=statement.executeQuery();
			
			String last=null;
			int number;
			if(rs.next()) {
				//assign last booking id to variable
				last=rs.getString("maxBookingID");
			}
			
			if(last==null) {
				return "B00001";
			}
			number=Integer.parseInt(last.split("B")[1]);
			number++;
		//format retriew number with B as a string
		return String.format("B%05d",number);
	}
	
	public static String generateScheduleID() throws SQLException {
		
		try {
			con=DBConection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="Select MAX(schID) AS maxScheduleID From guide_schedule";
		statement=con.prepareStatement(sql);
		rs=statement.executeQuery();
		
		String last=null;
		int number;
		if(rs.next()) {
			last=rs.getString("maxScheduleID");
		}
		
		if(last==null) {
			return "S001";
		}
		number=Integer.parseInt(last.split("S")[1]);
		number++;
	
		return String.format("S%03d",number);
	
	}
	
	
	//assign tour guide randomly
	public static String assignTourGuide(String startDate,String endDate) throws ClassNotFoundException, SQLException {
		
		//define array to assign tour guide
		List<String> freeGuides=freeGuide();
		List<String> dutyEndGuides=dutyEndGuide(endDate,startDate);
		
		//concat both list
		List<String> availableGuide=new ArrayList<>(freeGuides);
		availableGuide.addAll(dutyEndGuides);
		
		if(!availableGuide.isEmpty()) {
			//select guide among free guides randomly
			int index=ThreadLocalRandom.current().nextInt(availableGuide.size());
			return availableGuide.get(index);
		}
		
		System.out.print("No tour guide is available for the select date range");
		return null;
			
	}
	
	//get tour free or new guides 
	public static List<String> freeGuide(){
		
		List<String>free=new ArrayList<>();
		
		try {
			
			con=DBConection.getConnection();
			String sql="select GuidID from tourguide where GuidID not in (Select GuidID from guide_schedule)";
			statement=con.prepareStatement(sql);
			
			rs=statement.executeQuery();
			while(rs.next()) {
				free.add(rs.getString("GuidID"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return free;
	}
	
	
	
	//retriev room from booking Id
	public static String retriewRoomNobyBookingID(String Book_ID){
		
		String roomNo=null;
		
		try {
			
			con=DBConection.getConnection();
			//retriev room no the given bookingID
			String sql="select RoomNo from booking where bookingID=?";
			statement=con.prepareStatement(sql);
			//fetch value to bookingiD
			statement.setString(1, Book_ID);
			
			rs=statement.executeQuery();
			while(rs.next()) {
				roomNo=rs.getString("RoomNo");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return roomNo;
	}
	
	
	//Get free guide from guide _schedule table
	public static List<String> dutyEndGuide(String endDate,String startDate) throws SQLException{
		
		List<String>dutyEnd=new ArrayList<>();
		
		try {
			
			con=DBConection.getConnection();
			//select guide from schedule table 
			String sql="select GuidID from tourguide where GuidID not in (Select GuidID from guide_schedule where not(StartDate <? and EndDate>?))";
			statement=con.prepareStatement(sql);
			
			statement.setDate(1,Date.valueOf(endDate));
			statement.setDate(2,Date.valueOf(startDate));
			
			rs=statement.executeQuery();
			while(rs.next()) {
				dutyEnd.add(rs.getString("GuidID"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (rs != null) rs.close();
            if (statement != null) statement.close();
            if (con != null) con.close();
		}
		return dutyEnd;
	}
	
	
	
	//set room Availablity
	public static void setRoomAvailability(String roomNo,int value) {
		
		try {
			
			con=DBConection.getConnection();
			//update room availability
			String sql="Update room set Availability=? where RoomNo=?";
			statement=con.prepareStatement(sql);
			statement.setInt(1,value);
			statement.setString(2,roomNo);
	
			int rs=statement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
	        // close connection
	        try {
	            if (statement != null) statement.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		
	}
	
	
	
	// assign RoomNo
	public static String assignRoomNo(String type,String hotel) {
		
		ArrayList<String> roomNo=new ArrayList<>();
		String selectedRoom=null;
		
		try {
			
			con=DBConection.getConnection();
			//retriev the room according to the user requirement
			String sql="select RoomNo from room where RoomType=? and Availability=1 and hotelID=?";
			statement=con.prepareStatement(sql);
			//set data 
			statement.setString(1,type);
			statement.setString(2,hotel);
	
			rs=statement.executeQuery();
			
			while(rs.next()) {
				roomNo.add(rs.getString("RoomNo"));
			}
			try {
				if(!roomNo.isEmpty()) {
					Random random=new Random();
					int index=random.nextInt(roomNo.size());
					selectedRoom=roomNo.get(index);
					setRoomAvailability(selectedRoom,0);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
	        // Clean up resources
	        try {
	            if (statement != null) statement.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		return selectedRoom;
	}
	
	/*public static void ScheduleInsert(String startDate,String guide,String bID,String endDate) {
		
		try {
			con=DBConection.getConnection();
			
			
			//insert query
			String sql = "INSERT INTO guide_schedule(schID,StartDate,EndDate,GuidID,bookingID)VALUES(?, ?, ?, ?, ?)";;
			
			statement=con.prepareStatement(sql);
			
			//assign schedule id
			String sID=generateScheduleID();
			System.out.println(sID);
			System.out.println(startDate);
			try {
				statement.setString(1,sID);
				statement.setDate(2,Date.valueOf(startDate));
				statement.setDate(3,Date.valueOf(endDate));
				statement.setString(4, guide);
				statement.setString(5, bID);
			
			}catch (IllegalArgumentException e) {
	            System.out.println("Date format is incorrect. Please use yyyy-mm-dd.");
	            return;
	        }
			int rs=statement.executeUpdate();
			
			if(rs>0) {
				System.out.println("Schedule Successfully inserted");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
			
	}*/
	
	
	//if the user select guide assign the details for Tour guide
	public static void AssignTourSchedule(String b_id,String s_date,String e_date,String guide) throws SQLException {
		
			
		
		try {
			
			con=DBConection.getConnection();
			
			//statement=con.prepareStatement(sql);
			Statement stm=con.createStatement();
			
			String id=generateScheduleID();
			
			String sql="Insert Into guide_schedule values('"+id+ "','"+s_date+"','"+e_date+"','"+guide+"','"+b_id+"')";
			//generate schedule id
			
			/*Date date1 = convertToDate(s_date);
			Date date2 = convertToDate(e_date);
			
			statement.setString(1,generateScheduleID());
			statement.setDate(2,date1);
			statement.setDate(3,date2);
			statement.setString(4,guide);
			statement.setString(5,b_id);*/
			
			int x=stm.executeUpdate(sql);
			if(x>0) {
				System.out.println("Guide Schedule Inserted");
			}
			else {
				System.out.println("Guide Schedule not Inserted");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
	        // Clean up resources
	        try {
	            if (statement != null) statement.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	
	
	public static void guideTourInsertted(int tourID,String guide) {
		
		try {
			con=DBConection.getConnection();
			
			
			//insert query
			String sql="INSERT INTO tours_guide (tourID, GuideID) VALUES (?,?)";
			
			statement=con.prepareStatement(sql);
			
			
			
			statement.setInt(1,tourID);
			statement.setString(2,guide);
			
			
			int rs=statement.executeUpdate();
			
			if(rs>0) {
				System.out.println("Schedule Successfully inserted");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
			
	}
	
	public static String lastBookIDRelease() {
		
	
		String id=null;
		
		try {
			
			con=DBConection.getConnection();
			
			String sql="select MAX(bookingID) AS maxBookingID From booking";
			statement=con.prepareStatement(sql);
	
			rs=statement.executeQuery();
			
			if(rs.next()) {
				id=rs.getString("maxBookingID");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	//retirev room type when given the room no
	public static String retrievRoomType(String roomNo) {
		
		
		String type=null;
		
		try {
			
			con=DBConection.getConnection();
			
			String sql="select RoomType from room where RoomNo=?";
			statement=con.prepareStatement(sql);
			statement.setString(1,roomNo);
	
			rs=statement.executeQuery();
			
			while(rs.next()) {
				type=rs.getString("RoomType");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return type;
	}
	
	
	//update Tour Guide schedule according to the user requirement
	public static void updateTourGuideSchedule(String sdate,String edate,String guideID,String b_ID) {
		
		try {
			con=DBConection.getConnection();
			
			
			//insert query
			String sql="Update guide_schedule Set StartDate=?, EndDate=?, GuidID=? Where BookID=?";
			
			statement=con.prepareStatement(sql);
			
			//assign schedule id
			statement.setDate(1,Date.valueOf(sdate));
			statement.setDate(2,Date.valueOf(edate));
			statement.setString(3, guideID);
			statement.setString(4, b_ID);
			
			
			int rs=statement.executeUpdate();
			
			if(rs>0) {
				System.out.println("Schedule Successfully inserted");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//delete schdule
	public static void deleteSchedule(String book_id) {
		
		try {
			con=DBConection.getConnection();
			
			String sql="Delete From guide_schedule Where bookingID=?";
			
			statement=con.prepareStatement(sql);
			statement.setString(1,book_id);
			int rs=statement.executeUpdate();
			
			if(rs>0) {
				
				System.out.println("guide_schedule delete success fully");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	//
}
