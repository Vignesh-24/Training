package day21;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataEx {

	public static void main(String[] args) throws SQLException {
		
		
		Connection con=DbConnect.getEYConnection();
		Statement st=con.createStatement();   
		ResultSet rs= st.executeQuery("select * from users");    
		ResultSetMetaData rsmd=rs.getMetaData();
		System.out.println("No. of Cols =" +rsmd.getColumnCount());
		
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			
			System.out.println(rsmd.getColumnName(i)+" "+rsmd.getColumnTypeName(i)+" "+rsmd.getColumnLabel(i));
			
		}
		
		con.close();

	}

}
