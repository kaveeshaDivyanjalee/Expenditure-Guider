package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConection {
	
	private static String url="jdbc:mysql://localhost:3306/onlinetourguide?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
	private static String user="root";
	private static String password="Dini@0507";
	private static Connection conn;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		try {
		
			Class.forName("com.mysql.jdbc.Driver");	
			 conn=DriverManager.getConnection(url, user, password);
		}catch(Exception ex) {
			System.out.println("Database connect not successfully");
		}
		
		return conn;
	}

	
}
