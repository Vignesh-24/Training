package day21;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;



public class DbConnectionInfo {

	public static void main(String[] args) {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ey?useSSL=false", "root", "lufi2412");
			System.out.println(con); 
			DatabaseMetaData dbmd=con.getMetaData(); 
			System.out.println("DatabaseProductName     :  "+dbmd.getDatabaseProductName()); 
			System.out.println("DatabaseProductVersion  :"+dbmd.getDatabaseProductVersion());
			System.out.println("getStringFunctions            : "+dbmd.getStringFunctions()); 
			System.out.println("DriverMajorVersion          : "+dbmd.getDriverMajorVersion()); 
			System.out.println("DriverMinorVersion          :"+dbmd. getDriverMinorVersion ());
			System.out.println("DriverName           : "+dbmd.getDriverName ()); 
			System.out.println("SQLKeywords           : "+dbmd.getSQLKeywords()); 
			con.close(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
