package day22;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import day21.DBUtiility;


public class CustomerMasterDAOImpl implements CustomerMasterDAO{
	
	Connection con=null;
	PreparedStatement stmt;
	
	public void connect() {
		Connection connection=DBUtiility.getConnection();
		this.con=connection;
	}
	
	@Override
	public int insertCustomer(CustomerMasterDTO cust) {
		
		try {
			
			stmt=con.prepareStatement("Insert into customer values(?,?,?,?,?)");
			stmt.setInt(1, cust.getCustomerno());
			stmt.setString(2, cust.getCustomername());
			stmt.setString(3, cust.getCustomeremail());
			stmt.setString(4, cust.getCustomeraddress());
			stmt.setLong(5, cust.getCustomerphone());
			stmt.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	
		return 1;
	}

	
	@Override
	public int deleteCustomer(int customerno) {
		
		try {
			stmt=con.prepareStatement("Delete from customer where customerno=?");
			stmt.setInt(1, customerno);
			stmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	
		return 1;
	}

	@Override
	public int updateCustomer(CustomerMasterDTO cust) {
		if(this.deleteCustomer(cust.getCustomerno())==1 && this.insertCustomer(cust)==1) {
			return 1;}
		return 0;
	}

	@Override
	public CustomerMasterDTO getCustomer(int customerno) {
		
		CustomerMasterDTO cust=new CustomerMasterDTO();
		try {

			stmt=con.prepareStatement("select * from customer where customerno=?");
			stmt.setInt(1, customerno);
			ResultSet res=stmt.executeQuery();
			while(res.next()) {
				cust.setCustomername(res.getString(2));
				cust.setCustomerno(res.getInt(1));
				cust.setCustomeraddress(res.getString(4));
				cust.setCustomeremail(res.getString(3));
				cust.setCustomerphone(res.getLong(5));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
	
			return null;
		}
		
		

		return cust;
	}

	@Override
	public Set<CustomerMasterDTO> getAllCustomers() {
		Set<CustomerMasterDTO> customers=new HashSet<>();
		try {
			stmt=con.prepareStatement("select * from customer");
			ResultSet res=stmt.executeQuery();
			while(res.next()) {
				CustomerMasterDTO cust=new CustomerMasterDTO();
				cust.setCustomername(res.getString(2));
				cust.setCustomerno(res.getInt(1));
				cust.setCustomeraddress(res.getString(4));
				cust.setCustomeremail(res.getString(3));
				cust.setCustomerphone(res.getLong(5));
				customers.add(cust);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return customers;
	}
	
	public void close() {
		DBUtiility.closeConnection(null);
	}


}
