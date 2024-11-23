
package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Controller.DBConection;

public class HotelDataAccess {
	
	private static Connection con=null;
	private static PreparedStatement  statement=null;
	private static ResultSet rs=null;
	
	
	public static ArrayList<String> hotelNameGenerator(String tourName){
		
		ArrayList<String> names=new ArrayList<>();
		
		try {
			con=DBConection.getConnection();
			
			String sql="Select h.name from hotel h,hotel_tour ht,tour t where ht.hotelID=h.hotelID and ht.tourID=t.tourID and t.Title=?";
			statement=con.prepareStatement(sql);
			statement.setString(1, tourName);
			rs=statement.executeQuery();
			
			while(rs.next()) {
				names.add(rs.getString("name"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return names;
	
	}
	
	public static String retrievHotelID(String hotelname) throws ClassNotFoundException, SQLException {
		
		con=DBConection.getConnection();
		
		String sql="Select hotelID from hotel where name=?";
		statement=con.prepareStatement(sql);
		statement.setString(1, hotelname);
		rs=statement.executeQuery();
		
		String id = null;
		if(rs.next()) {
			id=rs.getString("hotelID");
		}
		return id;
	}
	
	public static String hotelNameusingId(String hotelId){
		
		String name=null;
		
		try {
			con=DBConection.getConnection();
			
			String sql="Select name from hotel where hotelID=?";
			statement=con.prepareStatement(sql);
			statement.setString(1, hotelId);
			rs=statement.executeQuery();
			
			if(rs.next()) {
				name=rs.getString("name");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return name;
	
	}
	 

}
