package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;


public class CustomerDAOImpl implements CustomerMasterDAO,Cloneable{
	private Properties prop;
	private static CustomerDAOImpl customerDAOImpl;
	
	
	private CustomerDAOImpl(Properties prop) {
		this.prop=prop;
	}
	
	
	synchronized public static CustomerDAOImpl getCustomerImpl(Properties prop) {
		
		if (customerDAOImpl==null) {
			customerDAOImpl=new CustomerDAOImpl(prop);
			return customerDAOImpl;
		}
		else {
			return customerDAOImpl.createClone();
		}
		
	}
	
	
	public CustomerDAOImpl createClone() {
		try {
			return (CustomerDAOImpl)super.clone();
		}catch(Exception e) {
			return null;
		}
	}
	

	@Override
	public int insertCustomer(CustomerMasterDTO cust) {
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("Insert into customer values(null,?,?,?,?)");
			stmt.setString(1, cust.getCustomername());
			stmt.setString(2, cust.getCustomeremail());
			stmt.setString(3, cust.getCustomeraddress());
			stmt.setLong(4, cust.getCustomerphone());
			stmt.execute();
			DBUtility.closeConnection(null);
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
			return 0;
		}
	
		return 1;

	}

	@Override
	public int deleteCustomer(int customerno) {
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("Delete from customer where customerno=?");
			stmt.setInt(1, customerno);
			stmt.execute();
			DBUtility.closeConnection(null);
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
	
		return 1;
	}

	@Override
	public int updateCustomer(CustomerMasterDTO cust) {
		
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("update customer set customername=?,customeremail=?,customerphone=?,customeraddress=? where customerno=?");
			stmt.setString(1, cust.getCustomername());
			stmt.setString(2, cust.getCustomeremail());
			stmt.setLong(3, cust.getCustomerphone());
			stmt.setString(4, cust.getCustomeraddress());
			stmt.setInt(5, cust.getCustomerno());
			stmt.execute();
			DBUtility.closeConnection(null);
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
		
		return 1;
	}

	@Override
	public CustomerMasterDTO getCustomer(int customerno) {
		CustomerMasterDTO cust=new CustomerMasterDTO();
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("select * from customer where customerno=?");
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
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("select * from customer");
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

}
