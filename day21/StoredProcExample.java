package day21;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class StoredProcExample {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DbConnect.getEYConnection();
		CallableStatement cs;
		Scanner sc=new Scanner(System.in);
		cs=con.prepareCall("{call proc1(?,?)}");
		int i=0;
		while(i<3) {
			System.out.println("Enter Userid to get name");
			cs.setInt(1,sc.nextInt());
			cs.registerOutParameter(2, Types.VARCHAR); 
			cs.execute(); 
			System.out.println("Name: "+cs.getString(2));
			i++;
		}
		
	
		con.close();
		sc.close();

	}

}
