package Services;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import Controller.DBConection;
import Model.Payment;
import Model.TravelPlanner;

//// Inheritance: TravelPlannerDBUtil inherits from UserBaseOperations
public class TravelPlannerDBUtil extends UserBaseOperations {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	private static PreparedStatement  statement=null;
    
	public TravelPlannerDBUtil() {
		
	}
	
	
	public static List<TravelPlanner> getTravelPlanner(String UserName) {
		
		ArrayList<TravelPlanner> TrvlP = new ArrayList<>();
		
		try {
			
			con = DBConection.getConnection();
			
			String sql = "SELECT * FROM travelPlanner WHERE UserName =?";
			statement = con.prepareStatement(sql);
			statement.setString(1,UserName);
			rs = statement.executeQuery();
			
			while (rs.next()) {
				int UserId = rs.getInt(1);
				String UserName1 = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
				String FirstName = rs.getString(5);
				String LastName = rs.getString(6);
				
				
				byte[] ProfilePic = rs.getBytes(7);
	            String profile = (ProfilePic != null) ? Base64.getEncoder().encodeToString(ProfilePic) : null;
				Date CreateDate = rs.getDate(8);
				String mobile = rs.getString(9);
				
				//int userID,String userName,String firstName,String lastName,String email,String password,String mobileNo, byte[]  profilePic,Date createDate2
				TravelPlanner tp = new TravelPlanner(UserId,UserName1,FirstName,LastName,email,password,mobile,profile,CreateDate);
				TrvlP.add(tp);
			}
			
		} catch (Exception e) {
			
		}
		
		return TrvlP;	
	}
	
	
	public static boolean InsertTravelPlanner(String UserName, String password, String email, String FirstName, String LastName, byte[] ProfilePi, Date CreateDate,String mobile) {
    	
    	boolean isSuccess = false;
    	
    	try {
            // Create database connection
            con = DBConection.getConnection();
            if (con == null) {
                throw new Exception("Database connection is null");
            }

            String sql = "INSERT INTO travelPlanner (UserName, password, email, FirstName, LastName, ProfilePic, CreateDate, mobileNo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, UserName);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, FirstName);
            pstmt.setString(5, LastName);
            pstmt.setBytes(6, ProfilePi);
            pstmt.setDate(7, (java.sql.Date) CreateDate);
            pstmt.setString(8, mobile);

            int rs = pstmt.executeUpdate(); // // Execute the query

            isSuccess = rs > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isSuccess;
    }
    
    public static boolean UpdateTravelPlanner(int UserId, String UserName, String password, String email, String FirstName, String LastName,byte[] ProfilePi, Date CreateDate) {
    	
    	try {
    		
    		con = DBConection.getConnection();
    		
    		String sql = "UPDATE travelPlanner SET UserName=?,password=?,email=?, FirstName=?,LastName=?,ProfilePic=?,CreateDate=? where UserID=1";
    		statement=con.prepareStatement(sql);
    	
    		statement.setString(1, UserName);
    		statement.setString(2, password);
            statement.setString(3, email);                       
            statement.setString(4, FirstName);
            statement.setString(5, LastName);
            if (ProfilePi != null) {
            	statement.setBytes(6, ProfilePi);  // Set profile picture binary data
            } else {
            	statement.setNull(6, java.sql.Types.BLOB);  // If no picture, set as null
            }
            statement.setDate(7, (java.sql.Date) CreateDate);
            statement.setInt(6, UserId);
    		int rs = statement.executeUpdate();
    		
    		if(rs > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
 
    public static List<TravelPlanner> getTravelPlannerDetails(String UserId) {
    	
    	int convertedUserID = Integer.parseInt(UserId);
    	
    	ArrayList<TravelPlanner> TrvlP = new ArrayList<>();
    	
    	try {
    		
    		con = DBConection.getConnection();
    		stmt = con.createStatement();
    		String sql = "SELECT * FROM travelPlanner WHERE UserId='"+convertedUserID+"'";
    		rs = stmt.executeQuery(sql);
    		
    		while(rs.next()) {
    			int UserId1 = rs.getInt(1);
    			String UserName = rs.getString(2);
    			String password = rs.getString(3);
				String email = rs.getString(4);
				String FirstName = rs.getString(5);
				String LastName = rs.getString(6);
				byte[] ProfilePic = rs.getBytes(7);
				String profile=Base64.getEncoder().encodeToString(ProfilePic);
				
				Date CreateDate = rs.getDate(8);
				String mobile = rs.getString(9);
    			
				////int userID,String userName,String firstName,String lastName,String email,String password,String mobileNo, byte[]  profilePic,Date createDate2
    			TravelPlanner tp = new TravelPlanner(UserId1, UserName,FirstName,LastName, email,password ,mobile , profile, CreateDate);
    			TrvlP.add(tp);
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}	
    	return TrvlP;	
    }
    
    
    public static boolean DeleteTravelPlanner(String UserId) {
    	
    	int convUserId = Integer.parseInt(UserId);
    	
    	try {
    		
    		con = DBConection.getConnection();
    		
    		String sql = "DELETE FROM travelPlanner WHERE UserId=?";
    		statement = con.prepareStatement(sql);
    		
    		statement.setInt(1,convUserId);
    		int rs = statement.executeUpdate();
    		
    		if (rs > 0) {
    			System.out.println("Delete Success");
    			isSuccess = true;
    		}
    		else {
    			System.out.println("Delete unSuccess");
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }

	@Override
	public boolean Validate(String UserName, String Password) {
		// TODO Auto-generated method stub
		boolean isSuccess=false;
		try {
			//Create database connection
			con=DBConection.getConnection();
			
			String sql = "SELECT * FROM travelPlanner where UserName=? and password=?";
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


