package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Controller.DBConection;

public class TravelPlannerDataAccessService {
	
	private static Connection con=null;
	private static PreparedStatement  statement=null;
	private static ResultSet rs=null;
	
	public static int retrievUserID(String mobile,String email) {
		
		int id=0;
		try {
			con=DBConection.getConnection();
			
			String sql="Select UserId From travelplanner where mobileNo=? and email=?";
			statement=con.prepareStatement(sql);
			statement.setString(1,mobile);
			statement.setString(2,email);
			rs=statement.executeQuery();
			
			if(rs.next()) {
				id=rs.getInt("UserId");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return id;
		
	}
}
