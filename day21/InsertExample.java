package day21;

import java.sql.Connection;
import java.sql.Statement;

public class InsertExample {
	
	public static void main(String[] args) {
		try {
			
			
			Connection con=DbConnect.getEYConnection();
			Statement st=con.createStatement();
			System.out.println(st.executeUpdate("insert into users values(2,'lulu','1234',0)"));
			System.out.println(st.executeUpdate("insert into users values(3,'dhoni','cool',0)"));
			System.out.println(st.executeUpdate("insert into users values(4,'vijay','thalapathy',0)"));
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


}
