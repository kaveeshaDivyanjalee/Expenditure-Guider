package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;



import Controller.DBConection;
import Model.Tour;

public class TourDataAccess {
	
	//create static varaible for db connection
	private static Connection con=null;
	private static PreparedStatement  statement=null;
	private static ResultSet rs=null;
	

	
	
	public static List<Tour> getTourDetailsBycatergory(String CatID) throws ClassNotFoundException, SQLException{
		
		//create list type arraylist to store tours
		List<Tour> tour=new ArrayList<>();
		PreparedStatement imageStatement = null;
		ResultSet imageRs = null;
		
		try {
		
			
			con=DBConection.getConnection();
			//statement=con.createStatement();
			
			//sql query
					
			String sql="Select * From tour Where catergoryID= ?";
			statement=con.prepareStatement(sql);
			statement.setString(1, CatID);
			rs=statement.executeQuery();
			
			while(rs.next()) {
				
				int tourID=rs.getInt(1);
				String title=rs.getString(2);
				String description=rs.getString(3);
				double cost=rs.getDouble(4);
				String duration=rs.getString(5);
				String catergeryID=rs.getString(6);
				String adminID=rs.getString(7);
				
				//retreiw the coverImage
				byte[] coverImage=rs.getBytes(8);
				String coverImageBase64 = Base64.getEncoder().encodeToString(coverImage);
				String city=rs.getString(9);
				String nearCity=rs.getString(10);
				
				
				//convert image
				
				//get image gallery
				List<String> imgGalllery=new ArrayList<>();
				String gallery="Select ImgURL From tour_imagegalary Where tourID ='"+tourID+"'";
				imageStatement=con.prepareStatement(gallery);
				imageRs=imageStatement.executeQuery();
				
				while(imageRs.next()) {
					imgGalllery.add(imageRs.getString("imgURL"));
				}
				
				
				//object for assign list
				Tour t1=new Tour(tourID,title,description,cost,duration,catergeryID,adminID,coverImageBase64,city,nearCity,imgGalllery);
				
				//assign object to list
				tour.add(t1);
				System.out.println(tour.get(0));
				
				
			}
			
		}catch(SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}finally{
			con.close();
		}
		
		return tour;
		
	}
	
	public static ArrayList<String> tourNameGenerator(){
		
		ArrayList<String> tourTitle=new ArrayList<>();
		
		try {
			
			con=DBConection.getConnection();
			
			String sql="Select * from tour";
			statement=con.prepareStatement(sql);
			rs=statement.executeQuery();
			
			while(rs.next()) {
				tourTitle.add(rs.getString("Title"));
			}
			rs.close();
			statement.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tourTitle;
	}
	public static List<Tour> tourDetails(String name) throws ClassNotFoundException, SQLException{
		
		List<Tour> tour=new ArrayList<>();
		
		try {
		
			
			con=DBConection.getConnection();
			//statement=con.createStatement();
			
			//sql query
					
			String sql="Select * From tour Where Title= ?";
			statement=con.prepareStatement(sql);
			statement.setString(1, name);
			rs=statement.executeQuery();
			
			while(rs.next()) {
				
				int tourID=rs.getInt(1);
				String title=rs.getString(2);
				String description=rs.getString(3);
				double cost=rs.getDouble(4);
				String duration=rs.getString(5);
				String catergeryID=rs.getString(6);
				String adminID=rs.getString(7);
				
				//retreiw the coverImage
				byte[] coverImage=rs.getBytes(8);
				String coverImageBase64 = Base64.getEncoder().encodeToString(coverImage);
				String city=rs.getString(9);
				String nearCity=rs.getString(10);
				
				
				//convert image
				
				//get image gallery
				List<String> imgGalllery=new ArrayList<>();
				String gallery="Select ImgURL From tour_imagegalary Where tourID ='"+tourID+"'";
				rs=statement.executeQuery(gallery);
				
				while(rs.next()) {
					imgGalllery.add(rs.getString("imgURL"));
				}
				
				
				//object for assign list
				Tour t1=new Tour(tourID,title,description,cost,duration,catergeryID,adminID,coverImageBase64,city,nearCity,imgGalllery);
				
				//assign object to list
				tour.add(t1);
				System.out.println(tour.get(0));
				
				
			}
			
		}catch(SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}finally{
			con.close();
		}
		
		return tour;
		
	}
	
	public static String getTourNameByTourID(int tourId) throws ClassNotFoundException, SQLException{
		
		//create list type arraylist to store tours
		String name=null;
		
		try {
		
			con=DBConection.getConnection();
			
			//sql query
					
			String sql="Select * From tour Where tourID= ?";
			statement=con.prepareStatement(sql);
			statement.setInt(1, tourId);
			rs=statement.executeQuery();
			
			if(rs.next()) {
								
				 name=rs.getString(2);
								
			}
			
		}catch(SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}finally{
			con.close();
		}
		
		return name;
		
	}
	
}
