package day21;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PreparedStmtExample {
	
	public static void main(String[] args) {
		
		try {
			
			Connection con=DbConnect.getEYConnection();
			PreparedStatement ps=con.prepareStatement("select uname from users where uid=?");
			int i=0;
			Scanner scanner=new Scanner(System.in);
			ResultSet resultSet;
			while(i<3) {
				
				System.out.println("Enter Userid to get name");
				ps.setInt(1, scanner.nextInt());
				resultSet=ps.executeQuery();
				while(resultSet.next())
					System.out.println(resultSet.getString(1));
				i++;
			}
			
			con.close();
			scanner.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
