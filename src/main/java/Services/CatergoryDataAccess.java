package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Controller.DBConection;

public class CatergoryDataAccess {
	
	private static Connection con=null;
	private static PreparedStatement statement=null;
	private static ResultSet rs=null;
	
	
	public static String generateIDbyName(String catName) {
		
		String catID=null;
		try {
			con=DBConection.getConnection();
			//statement=con.createStatement();
			
			String sql="Select CategoryID From category Where LOWER(Catergory)= LOWER(?)";
			statement=con.prepareStatement(sql);
			statement.setString(1, catName);
			rs=statement.executeQuery();
			
			
			if(rs.next()) {
				catID=rs.getString(1);
			}
			
		}catch(Exception ex) {
			System.out.println("invalid");
		}
		return catID;
	}
	
}
