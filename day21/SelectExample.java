package day21;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectExample {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con=DbConnect.getEYConnection();
		
		String sql="Select * from users";
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery(sql);
		System.out.println("Userid UserName Password Flag");
		while(res.next()) {
			System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getString(3)+"\t"+res.getInt(4)+"\t");
		}
		con.close();

	}

}
