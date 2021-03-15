package day21;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class TransactionDemo {

	public static void main(String[] args) throws SQLException {
		
		Connection con=DbConnect.getEYConnection();
		con.setAutoCommit(false);
		
		Statement st=con.createStatement();
		Savepoint spFirst=null;
		
		try {
			
			st.executeUpdate("update users set flag=1 where uid=1");
			spFirst=con.setSavepoint("first");
			st.executeUpdate("update users set flag=1 where uuid=2");
			con.commit();
			con.close();
			
		}catch(Exception e) {
			System.out.println("Rolling Back upto savepoint");
			con.rollback(spFirst);
			con.commit();
			con.close();
		}
	}

}
