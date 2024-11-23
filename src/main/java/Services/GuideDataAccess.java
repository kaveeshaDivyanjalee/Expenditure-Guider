package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Controller.DBConection;

public class GuideDataAccess extends UserBaseOperations{

	
	private static Connection con=null;
	private static PreparedStatement  statement=null;
	private static ResultSet rs=null;
	
	@Override
	public boolean Validate(String UserName, String Password) {
		// TODO Auto-generated method stub
		boolean isSuccess=false;
		//convert to integer
		int uid=Integer.parseInt(UserName);
		try {
			//Create database connection
			con=DBConection.getConnection();
			String sql = "SELECT * FROM user_profiles where id=? and password=?";
			statement = con.prepareStatement(sql);
			statement.setInt(1,uid);
			statement.setString(2,Password);
			rs=statement.executeQuery();
			
			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	public static String retriewGuideName(String guideID) {
		
		
		String name=null;
		
		try {
			
			con=DBConection.getConnection();
			
			String sql="select CONCAT(FName, ' ', LName) AS FullName from tourguide where GuidID=?";
			statement=con.prepareStatement(sql);
			statement.setString(1,guideID);
	
			rs=statement.executeQuery();
			
			while(rs.next()) {
				name=rs.getString("FullName");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return name;
	}

}
