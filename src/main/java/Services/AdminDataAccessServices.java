package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import Controller.DBConection;

public class AdminDataAccessServices extends UserBaseOperations{
	
	//create static varaible for db connection
	private static Connection con=null;
	private static PreparedStatement  statement=null;
	private static ResultSet rs=null;
	
	public static String assignAdminId() throws SQLException, ClassNotFoundException {
		
		//define array to assign tour guide
		ArrayList<String> admin=new ArrayList<>();
		
		
		String selectedAdmin=null;
		
		try {
			con=DBConection.getConnection();
			
			String sql="select AdminID from administrator ";
			
			statement=con.prepareStatement(sql);
			rs=statement.executeQuery();
			
			while(rs.next()) {
				admin.add(rs.getString("AdminID"));
			}
			
			try {
				if(!admin.isEmpty()) {
					Random random=new Random();
					int index=random.nextInt(admin.size());
					selectedAdmin=admin.get(index);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
				
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			con.close();
		}
		
		return selectedAdmin;
	}
	
	// retriev admin ID
		public static String retriewAdmiiniID(String id) {
				
				
				String adminId=null;
				
				try {
					
					con=DBConection.getConnection();
					
					String sql="select AdminID from booking where bookingID=?";
					statement=con.prepareStatement(sql);
					statement.setString(1,id);
			
					rs=statement.executeQuery();
					
					while(rs.next()) {
						adminId=rs.getString("AdminID");
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				return adminId;
			}
		
		public static String  retrievAdminiDetails(String Uname) {
			
			
			String name=null;
			
			try {
				
				con=DBConection.getConnection();
				
				String sql="select CONCAT(Fname, ' ', LastName) AS FullName from administrator where AdminID=?";
				statement=con.prepareStatement(sql);
				statement.setString(1,Uname);
		
				rs=statement.executeQuery();
				
				while(rs.next()) {
					name=rs.getString("FullName");
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return name;
		}

	@Override
	public boolean Validate(String UserName, String Password) {
		// TODO Auto-generated method stub
		boolean isSuccess=false;
		try {
			//Create database connection
			con=DBConection.getConnection();
			String sql = "SELECT * FROM administrator where AdminID=? and password=?";
			statement = con.prepareStatement(sql);
			statement.setString(1,UserName);
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

}
