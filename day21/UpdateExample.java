package day21;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateExample {

	public static void main(String[] args) throws SQLException {
		
		Connection con=DbConnect.getEYConnection();
		PreparedStatement ps=con.prepareStatement("update users set flag=1 where uid=?");
		int i=0;
		Scanner scanner=new Scanner(System.in);
	
		
		while(i<3) {
			
			System.out.println("Enter Userid to update flag");
			ps.setInt(1, scanner.nextInt());
			ps.executeUpdate();
			System.out.println("updated");
			i++;
		}
		
		con.close();
		scanner.close();

	}

}
