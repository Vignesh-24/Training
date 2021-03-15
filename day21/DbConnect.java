package day21;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
	
	public static Connection getEYConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ey", "root", "lufi2412");
			return con;
			
		}catch (Exception e) {
			System.out.println("Connection Failed");
			return null;
		}
		
	}

}
